package runner;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestCase;
import com.eviware.soapui.model.testsuite.TestRunner;

import builder.CsvRequestBuilder;
import builder.RequestTemplate;
import requests.SampleRequest;

public class CsvTestRunner <T extends RequestTemplate> {
	
	private CsvRequestBuilder<T> _builder;
	private List<T> _beans;
	
	public CsvTestRunner(String filePath, Class<T> type) throws IllegalStateException, FileNotFoundException {		
		_builder = new CsvRequestBuilder<T>(filePath, type);
		_beans = _builder.getBeans();
	}
	
	public List<T> getBeans() {
		return _beans;
	}
	
	public void dumpBeansToConsole() {
		Iterator<T> i = _beans.iterator();
		while(i.hasNext()) {
			T req = i.next();			
			Iterator<Entry<String, String>> it = req.getPropertiesIterator();
        	while(it.hasNext()) {        		
        		Entry<String, String> pair =  (Entry<String, String>) it.next();
        		System.out.println(pair.getKey()+ " " + pair.getValue());        		
        	}            
        	System.out.println("\n");			
		}
	}
	
	public void runTest(String testSuite, String testToRun, TestRunner runner) {		
		Iterator<T> i = _beans.iterator();
		while (i.hasNext()) {
			T req = (T) i.next();			
			Iterator<Entry<String, String>> it = req.getPropertiesIterator();
			while (it.hasNext()) {
				Map.Entry<String, String> pair = (Entry<String, String>) it.next();
				runner.getRunContext().setProperty(pair.getKey(), pair.getValue());
				TestCase testCase = runner.getTestRunnable().getProject().getTestSuiteByName(testSuite)
						.getTestCaseByName(testToRun);
				PropertiesMap map = new PropertiesMap();
				map.put(pair.getKey(), pair.getValue());
				testCase.run(map, false);
			}
		}
	}

}
