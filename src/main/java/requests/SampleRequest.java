package requests;

import java.util.HashMap;
import com.opencsv.bean.CsvBindByName;
import builder.RequestTemplate;

public class SampleRequest extends RequestTemplate {

	@CsvBindByName(column = "ClientRef", required = true)
	public String clientRef;

	@CsvBindByName(column = "Status", required = true)
	public String status;

	@Override
	public void CreateMap() {
		properties = new HashMap<String, String>();
		properties.put("ClientRef", clientRef);
		properties.put("Status", status);
	}

}