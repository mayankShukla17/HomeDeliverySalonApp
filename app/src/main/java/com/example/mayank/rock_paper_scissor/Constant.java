package com.example.mayank.rock_paper_scissor;

//import com.android.tonyvu.sc.demo.model.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Constant {
    public static final List<Integer> QUANTITY_LIST = new ArrayList<Integer>();

    static {
        for (int i = 1; i < 11; i++) QUANTITY_LIST.add(i);
    }

    public static final Product PRODUCT1 = new Product(1, "Bleach", BigDecimal.valueOf(499.0), "Bleaching helps to lighten your facial hair making them less visible. The usual benefit of face bleaching is lightening the skin tone by reducing the melanin level in your skin. Bleaching removes all the dullness enhancing the skin tone.", "bleach");
    public static final Product PRODUCT2 = new Product(2, "Bridal Package", BigDecimal.valueOf(5199.0), "This package is useful to pamper the bride a few days before the wedding.  You are handed over to the experts who will groom you into a charming diva before your D-day. This package is a must to get an instant glow and freshness.", "bridalca");
    public static final Product PRODUCT3 = new Product(3, "detan", BigDecimal.valueOf(2399.0), "", "detanca");
    public static final Product PRODUCT4 = new Product(4, "Facial", BigDecimal.valueOf(999.0), " Facial massage is essential for better blood circulation for the skin and relaxes you  It provides deep cleansing to your skin. In our rushed schedule, we end up skipping intensive cleansing — facial treatment helps you here  Also, it helps your eyes rejuvenate too.\n", "facialca");
    public static final Product PRODUCT5 = new Product(5, "Hair Coloring", BigDecimal.valueOf(4199.0), " Trying a new shade or revitalizing natural tones can make you look and feel totally different! ", "haircoloca");

    public static final Product PRODUCT8 = new Product(8, "Makeover", BigDecimal.valueOf(2000.0), "", "makeupca");
    public static final Product PRODUCT9 = new Product(9, "Manicure", BigDecimal.valueOf(1000.0), "", "manicureca");
    public static final Product PRODUCT10= new Product(10, "BodyMassage", BigDecimal.valueOf(349.0), "", "masgca");
    public static final Product PRODUCT11= new Product(11, "Mehndi", BigDecimal.valueOf(999.0), "", "mehndica");
    public static final Product PRODUCT6 = new Product(6, "Hair Cut", BigDecimal.valueOf(1499.0), " ", "haircutca");
    public static final Product PRODUCT7 = new Product(7, " Hair Spa", BigDecimal.valueOf(899.0), "", "hairspaca");
    public static final Product PRODUCT12= new Product(12, "NailBeauty", BigDecimal.valueOf(50.0), "", "nailca");

    public static final Product PRODUCT14 = new Product(14, "Pedicure", BigDecimal.valueOf(199.0), "", "pedicureca");
    public static final Product PRODUCT15= new Product(15, "Rebonding & Smoothening", BigDecimal.valueOf(3999.998140), "", "rebondca");
    public static final Product PRODUCT16= new Product(16, "Spa", BigDecimal.valueOf(1699.998140), "", "spaca");
    public static final Product PRODUCT17 = new Product(17, "Threading", BigDecimal.valueOf(129.998140), "", "threadingca");
    public static final Product PRODUCT18= new Product(18, "Under Eye Treatment", BigDecimal.valueOf(799.998140), "", "undereyeca");
    public static final Product PRODUCT19= new Product(19, "Waxing", BigDecimal.valueOf(199.998140), "", "waxingc");
    public static final List<Product> PRODUCT_LIST = new ArrayList<Product>();


    static {
        PRODUCT_LIST.add(PRODUCT1);
        PRODUCT_LIST.add(PRODUCT2);
        PRODUCT_LIST.add(PRODUCT3);
        PRODUCT_LIST.add(PRODUCT4);
        PRODUCT_LIST.add(PRODUCT5);
        PRODUCT_LIST.add(PRODUCT6);
        PRODUCT_LIST.add(PRODUCT7);
        PRODUCT_LIST.add(PRODUCT8);
        PRODUCT_LIST.add(PRODUCT9);
        PRODUCT_LIST.add(PRODUCT10);
        PRODUCT_LIST.add(PRODUCT11);
        PRODUCT_LIST.add(PRODUCT12);
        //PRODUCT_LIST.add(PRODUCT13);
        PRODUCT_LIST.add(PRODUCT14);
        PRODUCT_LIST.add(PRODUCT15);
        PRODUCT_LIST.add(PRODUCT16);
        PRODUCT_LIST.add(PRODUCT17);
        PRODUCT_LIST.add(PRODUCT18);
        PRODUCT_LIST.add(PRODUCT19);
    }

    public static final String CURRENCY = "₹";
}
