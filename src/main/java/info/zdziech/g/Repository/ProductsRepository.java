package info.zdziech.g.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class ProductsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Map  <String, Object> getProductmap (String idOfProduct )
    { try {
          String sql = "Select NAZWA_PRODUKTU, CENA_SPRZEDAZY from Produkty where id=? ";
          return jdbcTemplate.queryForMap(sql, idOfProduct);
    }
     catch (
    EmptyResultDataAccessException e) {
        return null;
    }}


     public String nameOfProduktu(String idOfProduct){
        try {
        String sql ="SELECT NAZWA_PRODUKTU FROM PRODUKTY WHERE ID=?";
        return jdbcTemplate.queryForObject(sql,String.class, idOfProduct);
   }  catch (EmptyResultDataAccessException e) {
        return null;
    }}

     public double priceOfProduct(String idOfProduct) {
         try {
             String sql = "SELECT CENA_SPRZEDAZY FROM PRODUKTY WHERE ID=?";
             return jdbcTemplate.queryForObject(sql, Double.class, idOfProduct);
         } catch (NullPointerException e) {
             return 0;
         }
     }

}
