import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.Geometry;

import java.io.IOException;


public class CoordConverter {

    public Geometry coordGetter(String address) {

        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyCQI06r-N-DESGnAzN278EMt3yoiBc5r5A")
                .build();
        GeocodingResult[] results = new GeocodingResult[0];

        {
            try {
                results = GeocodingApi.geocode(context,
                        address).await();
            } catch (ApiException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            return results[0].geometry;

//            String rawJson = gson.toJson(results[0].geometry);
//
//            Type foundListType = new TypeToken<ArrayList<CoordObject>>() {}.getType();
//
//            List<CoordObject> coords = new Gson().fromJson(rawJson, foundListType);
//
//            return coords;


        }

    }




}



