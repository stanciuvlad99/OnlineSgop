package ro.mycode.controllers;

import org.junit.jupiter.api.Test;
import ro.mycode.models.Products;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ControlProductsTest {

    @Test
    void testMinProductsWeight() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        Products product1 = new Products("2,GHI222JKL,tastatura,1100,2.3");
        Products product2 = new Products("3,MNO333PQR,monitor,1700,0.2");
        Products product3 = new Products("4,QWE444RTY,laptop,5600,2.5");
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = product2.toString();

        assertEquals(expected, controlProducts.minProductsWeight().toString());
    }

    @Test
    void testMinProductsPrice() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        Products product1 = new Products("2,GHI222JKL,tastatura,1100,2.3");
        Products product2 = new Products("3,MNO333PQR,monitor,1700,0.2");
        Products product3 = new Products("4,QWE444RTY,laptop,5600,2.5");
        products.add(product);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = product.toString();

        assertEquals(expected, controlProducts.minProductsPrice().toString());
    }

    @Test
    void testFindByProductsId() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = product.toString();

        assertEquals(expected, controlProducts.findByProductsId(product.getId()).toString());
    }

    @Test
    void testFindByProductsIdNull() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = null;

        assertEquals(expected, controlProducts.findByProductsId(product.getId() + 1));
    }

    @Test
    void testFindByName() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = product.toString();

        assertEquals(expected, controlProducts.findByName(product.getName()).toString());
    }

    @Test
    void testFindByNameNull() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = null;

        assertEquals(expected, controlProducts.findByName(product.getName() + 1));
    }

    @Test
    void testReturnIdByName() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        int expected = 1;

        assertEquals(expected, controlProducts.returnIdByName(product.getName()));
    }

    @Test
    void testReturnIdByNameNull() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        int expected = -1;

        assertEquals(expected, controlProducts.returnIdByName(product.getName() + 1));
    }

    @Test
    void testNextId() {
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        int expected = product.getId()+1;

        assertEquals(expected,controlProducts.nextId());
    }

    @Test
    void testNextIdNull() {
        ArrayList<Products> products = new ArrayList<>();
        ControlProducts controlProducts = new ControlProducts(products);
        int expected = -1;

        assertEquals(expected,controlProducts.nextId());
    }

    @Test
    void testAdd(){
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        ControlProducts controlProducts = new ControlProducts(products);
        controlProducts.add(product);
        int expected=1;

        assertEquals(expected,products.size());
    }

    @Test
    void testFindBySku(){
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = product.toString();

        assertEquals(expected, controlProducts.findBySku(product.getSku()).toString());
    }

    @Test
    void testFindBySkuNull(){
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        String expected = null;

        assertEquals(expected, controlProducts.findBySku(product.getSku()+1));
    }

    @Test
    void testUpdatePriceBySku(){
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,600,1.3");
        products.add(product);
        Products update= new Products("1,ABC111DEF,mouse,999,1.3");
        ControlProducts controlProducts = new ControlProducts(products);
        controlProducts.updatePrice(update);
        String expected=product.toString();

        assertEquals(expected,update.toString());
    }

    @Test
    void testRemove(){
        ArrayList<Products> products = new ArrayList<>();
        Products product = new Products("1,ABC111DEF,mouse,999,1.3");
        products.add(product);
        ControlProducts controlProducts = new ControlProducts(products);
        controlProducts.remove(product);
        int expected=0;

        assertEquals(expected, products.size());
    }
}