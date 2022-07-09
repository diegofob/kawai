package pe.edu.utp.kawaifood.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import java.util.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import pe.edu.utp.kawaifood.repository.DetallePedidoRepository;


@RestController
@RequestMapping(value = "api/dashboard", produces = "application/json")
public class DashboardRestController {

    private static final long serialVersionUID = 9178661439383356177L;
    private final DetallePedidoRepository pedidosData;

    public DashboardRestController(DetallePedidoRepository pedidosData){
        this.pedidosData = pedidosData;
    } 

    @GetMapping(value = "/pedidostotales", produces = MediaType.APPLICATION_JSON_VALUE)
    @JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
    public ResponseEntity<List<Map<String, Object>>> productos(){

        List<Map<String, Object>> datos = pedidosData.querySumaTotal();
        System.out.println("::: size : " +datos.size());

        for (Map<String, Object> map : datos) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }


        System.out.println("fin size");
        /*
        return  new ResponseEntity<List<Map<String, Object>>>(
            pedidosData.querySumaTotal(), HttpStatus.OK);
            */
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("descripcion", "Baylis 750ml");
            map.put("montototal", 40.00);
            map.put("cantidad", 4);
            list.add(map);
            return  new ResponseEntity<List<Map<String, Object>>>(
                datos, HttpStatus.OK);
            
    }


}