package Model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class Maps {

	private ArrayList<String> destination_addresses;

	private ArrayList<String> origin_addresses;

	private ArrayList<Row> rows;

	private String status;

}
