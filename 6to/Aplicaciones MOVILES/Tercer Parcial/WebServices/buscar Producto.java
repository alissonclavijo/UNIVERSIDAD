  //buscar producto

  btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                buscarProducto("https://10.40.11.191:8080/productos/buscar_producto.php");

            }
        });

    }

//servicio

//para ejecutar buscar
    private void buscarProducto(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        txtProducto.setText(jsonObject.getString("producto"));
                        txtPrecio.setText(jsonObject.getString("precio"));
                        txtFabricante.setText(jsonObject.getString("fabricante"));

                    } catch (JSONException e) {

                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        }

        );

        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);



    }

