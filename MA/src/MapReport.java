

import java.sql.*;

public class MapReport {

    private static Connection c = null;
    private static PreparedStatement mapinfo = null;
    private static ResultSet mapresult = null;

    private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String connectionDescriptor =
            "jdbc:DATABASESERVERURL;databasename=DATABASENAME";

    public static void main(String[] args) {

        try {
            // Establish JDBC connection

            Class.forName(driverClass);
            c = DriverManager.getConnection(connectionDescriptor, "USERNAME", "PASSWORD" );

            // Create the prepared statements

            mapinfo = c.prepareStatement(
                    "SELECT DISTINCT MAP.ID, MAP.Name, ( " +
                            "SELECT COUNT(CITY.Name) " +
                            "FROM [HS-ULM\\kratzer].CITY " +
                            "WHERE MAP.ID = CITY.MapID " +
                            ")'Number of Cities in the map', " +
                            "(SELECT COUNT(ROAD.IDFROM)/2 " +
                            "FROM [HS-ULM\\kratzer].ROAD " +
                            "WHERE MAP.ID = ROAD.MapID " +
                            ")'Number of roads in the map', " +
                            "( " +
                            "SELECT AVG(ROAD.Distance) " +
                            "FROM [HS-ULM\\kratzer].ROAD " +
                            "WHERE MAP.ID = ROAD.MapID " +
                            ")'Average length of the roads in a map', ENDCITIES.[Start City], ENDCITIES.[End City], ENDCITIES.Distance " +
                            "FROM [HS-ULM\\kratzer].MAP " +
                            "JOIN ( " +
                            "SELECT ROAD.MapID, SC.Name'Start City', EC.Name'End City', ROAD.Distance " +
                            "FROM [HS-ULM\\kratzer].ROAD " +
                            "JOIN ( " +
                            "SELECT ROAD.MapID, MIN(ROAD.IDfrom)'FromCity', MAX(ROAD.IDto)'ToCity' " +
                            "FROM [HS-ULM\\kratzer].ROAD " +
                            "JOIN ( " +
                            "SELECT ROAD.MapID, MAX(ROAD.Distance)'Distance' " +
                            "FROM [HS-ULM\\kratzer].ROAD " +
                            "GROUP BY ROAD.MapID " +
                            ") AS longestRoad ON longestRoad.Distance = ROAD.Distance AND longestRoad.MapID = ROAD.MapID " +
                            "GROUP BY ROAD.MapID " +
                            ") AS LC ON LC.MapID = ROAD.MapID AND LC.FromCity = ROAD.IDfrom AND LC.ToCity = ROAD.IDto " +
                            "JOIN ( " +
                            "SELECT CITY.MapID, CITY.ID, CITY.Name " +
                            "FROM  [HS-ULM\\kratzer].CITY " +
                            ") AS SC ON SC.ID = ROAD.IDfrom AND SC.MapID = ROAD.MapID " +
                            "JOIN ( " +
                            "SELECT CITY.MapID, CITY.ID, CITY.Name " +
                            "FROM  [HS-ULM\\kratzer].CITY " +
                            ") AS EC ON EC.ID = ROAD.IDto AND EC.MapID = ROAD.MapID " +
                            ") AS ENDCITIES ON ENDCITIES.MapID = MAP.ID"
            );

            mapresult = mapinfo.executeQuery();

            while (mapresult.next()) {
                Terminal.put(
                        "---------------------------------------\n" +
                                "Map " + mapresult.getString(2) + " (" + mapresult.getInt(1) + "):\n" +
                                "Cities: " + mapresult.getInt(3) + "\n" +
                                "Roads: " + mapresult.getInt(4) + "\n" +
                                "Average Road Length: " + mapresult.getInt(5) + " km\n" +
                                "The longest road runs from " + mapresult.getString(6) + " to "
                                + mapresult.getString(7) + " - length: " + mapresult.getInt(8) + " km\n" +
                                "---------------------------------------"
                );
            }

            mapresult.close();

        } catch (ClassNotFoundException e) {
            Terminal.put("Unable to open driver class ..." );
        } catch (SQLException e) {
            Terminal.put("Database error: " + e.getMessage());
        } finally {

            try {
                if (c != null) c.close();
            } catch (SQLException e) {
            }
        }
    }

}
