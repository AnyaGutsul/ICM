package reportActivity;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MyInterface {
	public void connect();
	public ArrayList<String> Query(ArrayList<String> strings);
}
