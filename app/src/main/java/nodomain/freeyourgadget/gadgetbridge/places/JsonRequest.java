package nodomain.freeyourgadget.gadgetbridge.places;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import nodomain.freeyourgadget.gadgetbridge.activities.ControlCenterv2;

public class JsonRequest {
    RequestQueue queue;
    String respuesta;

    public JsonRequest(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void parsePatientList(final CallBackObject onCallBack) {

        StringRequest strRequest = new StringRequest(Request.Method.GET, "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=" + ControlCenterv2.coords + "&radius=20&key=AIzaSyBTyCl6IDLJsHkFogICdWXET4_rfG5h7o4",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        ObjectMapper mapper = new ObjectMapper();

                        Log.d("conversion", response);
                        String student = null;
                        try {

                            JsonNode jsonNode = mapper.readTree(response);
                            respuesta = jsonNode.get("results").get(0).get("types").get(0).asText();
                            onCallBack.onSuccess(respuesta);
                        } catch (Exception e) {
                            Log.d("conversion", e.toString());
                            onCallBack.onFail("algo truena en el traductor");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("user", "value: " + error.toString());
                    }
                }) {

            //This is for Headers If You Needed
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/json; charset=UTF-8");
                return params;
            }


            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("tag", "test");
                return params;
            }
        };

        queue.add(strRequest);

    }
}
