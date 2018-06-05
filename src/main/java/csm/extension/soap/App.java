package csm.extension.soap;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

import builder.CsvRequestBuilder;
import builder.RequestTemplate;
import requests.SampleRequest;
import runner.CsvTestRunner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<SampleRequest> beans;
		try {
			CsvTestRunner<SampleRequest> runner= new CsvTestRunner<SampleRequest>("YOUR FILE HERE!", SampleRequest.class);			
			runner.dumpBeansToConsole();			
		}
		 catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
