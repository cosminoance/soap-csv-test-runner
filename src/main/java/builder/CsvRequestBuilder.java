package builder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBeanBuilder;

public class CsvRequestBuilder<T extends RequestTemplate> {
	private List<T> _beans;

	public CsvRequestBuilder(String reativeCsvPath, Class<T> typeClass)
			throws IllegalStateException, FileNotFoundException {
		// Read the CSV values into a bean
		_beans = (List<T>) new CsvToBeanBuilder(new FileReader(reativeCsvPath))
				.withType(typeClass)
				.build()
				.parse();
	}

	public List<T> getBeans() {
		return _beans;
	}
	
}
