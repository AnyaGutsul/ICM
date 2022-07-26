package reportActivity;

import java.util.ArrayList;

public class StubConnectionToServer implements MyInterface{
	
	private ArrayList<String> arr = new ArrayList<>();
	
	@Override
	public void connect() {}

	@Override
	public ArrayList<String> Query(ArrayList<String> strings) {
		return arr;
	}
	
	public void addArr(ArrayList<String> arr) {
		this.arr = arr;
	}
}
