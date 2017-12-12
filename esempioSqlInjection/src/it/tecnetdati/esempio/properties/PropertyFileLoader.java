package it.tecnetdati.esempio.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class PropertyFileLoader implements PropertyFileLoaderITF
{
    private final static String PATH_FILE_PROPERTIES_NAME = "/database.properties";
    
    public String getPathFileLoaded()
    {
        return PATH_FILE_PROPERTIES_NAME;
    }
    
    public Properties getPropertyFile() throws IOException
    {
        final Properties p = new Properties(); 
        /*
         * permette di ottenere direttamente uno stream associato alla risorsa remota, 
         * senza doverlo aprire esplicitamente 
         */
        final InputStream is = getClass().getResourceAsStream(getPathFileLoaded());
        try
        {
            if (is != null)
            {
                p.load(is);
            }
            else
            {
                throw new IOException("InputStream null. File non Trovato");
            }
        }
        finally
        {
            if (is != null) {
				is.close();
			}
        }
        return p;
    }


}

