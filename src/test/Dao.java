package test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ex3.AbstractDao;

public class Dao extends AbstractDao {

	public List<Object> findAllObjects() throws SQLException {

		List<Object> objects = new ArrayList<Object>();

		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit");
			while (rs.next()) {
				Object object = new Object();
				object.setNimi(rs.getString(2));
				object.setKood(rs.getString(3));
				object.setId(rs.getInt(1));

				objects.add(object);
			}
		} finally {
			closeResources();
		}
		return objects;
	}

	public void deleteRow(String id) throws SQLException {
		int row = Integer.parseInt(id);
		st = getConnection().createStatement();
		rs = st.executeQuery("DELETE FROM unit WHERE id=" + row);
		closeResources();
	}

	public void clearData() throws SQLException {
		st = getConnection().createStatement();
		rs = st.executeQuery("TRUNCATE TABLE unit");
		closeResources();
	}

	public List<Object> search(String parameter) throws SQLException {
		List<Object> objects = new ArrayList<Object>();
		try {
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM unit WHERE UPPER(name) LIKE UPPER('%"
					+ parameter + "%')");

			while (rs.next()) {
				Object object = new Object();
				object.setNimi(rs.getString(2));
				object.setKood(rs.getString(3));
				object.setId(rs.getInt(1));

				objects.add(object);
			}
		} finally {
			closeResources();
		}
		return objects;
	}

	public void addRow(String name, String code) throws SQLException {
		st = getConnection().createStatement();
		rs = st.executeQuery("INSERT INTO unit VALUES (NEXT VALUE FOR seq1,'"
				+ name + "','" + code + "')");
		closeResources();
	}

}