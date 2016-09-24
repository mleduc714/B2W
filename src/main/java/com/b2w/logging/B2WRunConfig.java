package com.b2w.logging;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;

import com.b2w.test.HasProperties;

public class B2WRunConfig implements HasProperties {
    private static HashMap<String, List<String>> jarPathMap = new HashMap<String, List<String>>(50);
    private static HashMap<String, Properties> propcache = new HashMap<String, Properties>();
    private static final String CONFIG_FILE_NAME = "B2WSelenium.properties";
    
    private Logger log;
    private Properties configprops;
    private Properties localeprops;
    
    public B2WRunConfig() {

    	Logger.getLogger(B2WRunConfig.class.getName()).setLevel(Level.INFO);
        File userConfigFile = null;  
        // Check in home
        if ((userConfigFile == null || !userConfigFile.exists()) && System.getenv("UserProfile") != null) 
            userConfigFile = new File(System.getenv("UserProfile"), CONFIG_FILE_NAME);

        // Load user defined B2WSelenium.properties configuration file
        String userConfigLocation = null;
        Properties userConfig = null;
        if (userConfigFile != null && userConfigFile.exists()) {
            userConfigLocation = userConfigFile.toURI().toString(); 
            userConfig = getProperties(userConfigLocation);
            if (userConfig != null) {
            	configprops = new Properties();
                for (Object prop : userConfig.keySet()) {
                	configprops.put(prop, userConfig.getProperty((String)prop));
                }
            }
        } else {
        	// If a user defined B2WSelenium.properties isn't found, 
        	// fall back to B2WSelenium.properties in project resources
        	configprops = getProperties("data/" + CONFIG_FILE_NAME);
        	if (configprops == null)
        		throw new RuntimeException("Unable to read B2WSelenium.properties!");
        }
        
     
       
     // Set up logging config
        String logConfigLocation = configprops.getProperty("logconfig");
        if (logConfigLocation == null)
            throw new RuntimeException("'logconfig' file location not specified in B2WSelenium.properties.");
        
        URL logconfig = null;
        if(!new File(logConfigLocation).exists()){
        	logconfig = getClass().getClassLoader().getResource(logConfigLocation);
        }else{
			try {
				logconfig = new File(logConfigLocation).toURI().toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
        }
        if (logconfig == null)
            throw new RuntimeException("Unable to read log config file!");
        //option to use properties or xml
        if (logconfig.getFile().endsWith(".properties"))
            PropertyConfigurator.configure(logconfig);
        else if (logconfig.getFile().endsWith(".xml"))
            DOMConfigurator.configure(logconfig);
        log = Logger.getLogger(getClass());
        if (userConfig == null)
            log.warn("NOTE: User defined config file not found! Using default Selenium.properties from project resources package.");
        setWebDriverProperty();
		// Update the property cache with the formatted configprops
		setProperties(userConfigLocation,configprops);
       
    }
    
  
	public String getProperty(String property) {
        String prop = configprops.getProperty(property);
        return prop==null ? "" : prop;
    }
    
    public void setProperty(String prop, String value) {
    	if(configprops != null) {
    		configprops.setProperty(prop, value);
    	}
    }
    
    public Properties getProperties(String file) {
    	Properties properties = propcache.get(file);
        if (properties == null) {
			try {
				propcache.put(file, properties = new Properties());
				InputStream in = null;
				if(file.startsWith("file:")) {
					in = new FileInputStream(new File(new URI(file)));
				} else {
					in = getClass().getClassLoader().getResourceAsStream(file);
				}
				if(in == null) {
					File localTarget = new File(file);
					if(!localTarget.exists()) {
						throw new FileNotFoundException();
					} else {
						in = new FileInputStream(localTarget);
					}
				}
					properties.load(new InputStreamReader(in, "UTF8"));
			} catch (FileNotFoundException fnf) {
				System.out.println(fnf.getMessage());
				propcache.remove(file);
				properties = null;
				if(log != null)
					log.warn("Properties file not found: " + file);
			} catch (Throwable t) {
				System.out.println(t.getMessage());
				propcache.remove(file);
				properties = null;
				if(log != null)
					log.warn("Error reading properties file: " + file);
			}
		}
        
        return properties;
    }
    
    /**
     * Update propcache with new Properties 
     * 
     * @param file Name of the original property file
     * @param props Updated properties 
     */
    private void setProperties(String file, Properties props){
    	propcache.put(file,props);
    }
    
  
    @SuppressWarnings("resource")
	public List<String> getPropertiesFiles(String path) {
        List<String> ret = null;
        String dataPath = path.replaceAll("[/]$", ""); 
        URL dir = getClass().getClassLoader().getResource(dataPath);
        if (dir == null){
        	File f = new File(dataPath);
        	try {
				dir = f.toURI().toURL();
			} catch (MalformedURLException e) {
				 dir = null;
			}
        }
        if (dir != null && dir.getProtocol().equals("file")) {
            try {
                ret = Arrays.asList(new File(dir.toURI()).list(new FilenameFilter() {
                    public boolean accept(File dir, String name) {
                        return name.endsWith(".properties");
                    }
                }));
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            dir = getClass().getResource(getClass().getSimpleName() + ".class");
            
            if (dir.getProtocol().equals("jar")) {
                if (jarPathMap.isEmpty()) {
                    try {
                        jarPathMap = new HashMap<String, List<String>>(50);
                        String jarpath = dir.getPath().substring(5, dir.getPath().indexOf("!"));
                        JarFile jar = new JarFile(URLDecoder.decode(jarpath, "UTF-8"));
                        
                        Enumeration<JarEntry> entries = jar.entries();
                        JarEntry entry = null;
                        while ( entries.hasMoreElements() && (entry = entries.nextElement()) != null ) {
                            String resource = entry.getName();
                            int index = resource.lastIndexOf('/');
                            String respath = index == -1 ? "" : resource.substring(0, index);
                            String resname = index == -1 ? resource : resource.substring(index + 1);
                            
                            List<String> list = jarPathMap.get(respath);
                            if (list == null)
                                jarPathMap.put(respath, list = new ArrayList<String>());
                            if (resname.endsWith(".properties"))
                            		list.add(resname);
                        }
                    } catch (IOException ioe) {
                        throw new RuntimeException(ioe);
                    }
                }
                
                return jarPathMap.get(dataPath);
            }
        }
        
        return ret;
    }
    
    
    public Properties getConfigProps() {
    	return configprops;
    }
    
    public Properties getLocalizedStrings(){
    	return localeprops;
    }
  
  
	 /**
	  * Log configuration properties for use in the HTML log headers
	  */
	 protected void logConfig(){
			StringBuilder sb = new StringBuilder();
			sb.append("CONFIG;");
			for(Object k : configprops.keySet()){
				sb.append(k.toString()).append("=").append(configprops.get(k).toString()).append(";");
			}
			log.info(sb.toString());
		}
	 
	 private void setWebDriverProperty() {
			boolean bLocalWD = Boolean.getBoolean(configprops.getProperty("useLocalWebDriver", "false").toLowerCase());
			String wdIE = getCurrentProjectPath() + "/webdriver/IEDriverServer.exe";
			String wdChrome = getCurrentProjectPath() + "/webdriver/chromedriver.exe";
			boolean wdChromeSet = !(System.getProperty("webdriver.chrome.driver") == null);

	
			if (!wdChromeSet || bLocalWD)
				System.setProperty("webdriver.chrome.driver", wdChrome);
			System.setProperty("webdriver.ie.driver", wdIE);

			System.out.println("useLocalWebDriver: (" + bLocalWD + ")");
			System.out.println("(webdriver.chrome.driver): " + System.getProperty("webdriver.chrome.driver"));
			System.out.println("(webdriver.ie.driver): " + System.getProperty("webdriver.ie.driver"));

		}
	 
		/**
		 * returns string with the current project path
		 */
		public static String getCurrentProjectPath()
		{
			String myProjectPath = new File(".").getAbsolutePath();

			myProjectPath = myProjectPath.replace("\\", "/");

			if(myProjectPath.endsWith("."))
			{
				myProjectPath = myProjectPath.substring(0,myProjectPath.length()-1);    		
			}

			if(myProjectPath.endsWith("/"))
			{
				myProjectPath = myProjectPath.substring(0,myProjectPath.length()-1);    		
			}
			return myProjectPath;
		}
		
}
