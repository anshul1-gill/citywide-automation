package com.dits.citywide.utilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ServerTimeUtil {

	public static String getServerTimeInPST(String baseUrl) {
		try {
			URL url = new URL(baseUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();

			String dateHeader = connection.getHeaderField("Date");
			if (dateHeader != null) {
				// Parse server date
				SimpleDateFormat serverFormat = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
				serverFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
				Date serverDate = serverFormat.parse(dateHeader);

				// Convert to PST format 
				SimpleDateFormat pstFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
				// PST/PDT depending on daylight savings
				pstFormat.setTimeZone(TimeZone.getTimeZone("America/Los_Angeles"));
				return pstFormat.format(serverDate);
			} else {
				return "Date header not found";
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "Error fetching server time";
		}
	}
}
