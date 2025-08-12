# CSV Parsing using Spring Boot

# Dependency

- To let spring boot parse the csv file we would need to add the apache-poi dependency in our application. This dependency is not available on [start.spring.io](http://start.spring.io) and hence we would need to search it [here](https://mvnrepository.com/artifact/org.apache.poi/poi/5.4.1)
    
    ```xml
    <!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
    <dependency>
        <groupId>org.apache.poi</groupId>
        <artifactId>poi-ooxml</artifactId>
        <version>5.4.1</version>
    </dependency>
    ```
    
- Also you would have to configure the max-file-size and min-file-size in application.properties
    
    ```xml
    #file configuration
    spring.servlet.multipart.max-file-size=10MB
    spring.servlet.multipart.min-file-size=1MB
    ```
    

# Parsing

- This is the excel sheet we would be parsing
    
    ![image.png](/images/csv/image.png)
    
    So we would need a productId, productName, productDesc, and productPrice fields in our ProductEntity
    
    ![image.png](/images/csv//images/csv/image%201.png)
    
- We would also need a ProductRepository for interacting with the database.
- Now we would create a new Java Class named ExcelHelper, in this class we would have 2 methods.
    - The first method would be responsible to check if the file passed is excel or not.
        
        ![image.png](/images/csv/image%202.png)
        
    - The second method would be responsible to convert the csv file to List of ProductEntity.
        
        ![image.png](/images/csv/image%203.png)
        
    - Here’s the entire code for this helper class:
        
        ```java
        package com.csvparse.csv_parsing.helper;
        
        import com.csvparse.csv_parsing.entity.ProductEntity;
        import org.apache.poi.ss.usermodel.Row;
        import org.apache.poi.xssf.usermodel.XSSFSheet;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import org.springframework.web.multipart.MultipartFile;
        
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        
        public class ExcelHelper {
        
            // This method checks if the uploaded file is a valid Excel file
            public static boolean isValidExcelFile(MultipartFile file) {
                return file.getContentType().equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            }
        
            //This method would convert excel to list of ProductEntity
            public static List<ProductEntity> convertExcelToProductList(InputStream inputStream) {
                List<ProductEntity> productList = new ArrayList<>();
                try{
        
                    XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
                    XSSFSheet sheet = workbook.getSheet("data");
        
                    int rowNumber = 0;
        
                    for (Row currentRow : sheet) {
                        // Skip the header row
                        if (rowNumber == 0) {
                            rowNumber++;
                            continue;
                        }
        
                        // Read data from each cell in the row
                        Integer productId = (int) currentRow.getCell(0).getNumericCellValue();
                        String productName = currentRow.getCell(1).getStringCellValue();
                        String productDesc = currentRow.getCell(2).getStringCellValue();
                        Double productPrice = currentRow.getCell(3).getNumericCellValue();
        
                        // Create a new ProductEntity and add it to the list
                        ProductEntity product = new ProductEntity(productId, productName, productDesc, productPrice);
                        productList.add(product);
        
                    }
        
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return productList;
            }
        }
        
        ```
        

- Now, we need to create a service class ProductService, it would have 2 methods
    - The first method would be to save the csv file in our database, and it would be named as saveProductList
        
        ![image.png](/images/csv/image%204.png)
        
    - The second method would be use to retrieve the data from the database
        
        ![image.png](/images/csv/image%205.png)
        
    - Here’s the complete ProductService code
        
        ```java
        package com.csvparse.csv_parsing.service;
        
        import com.csvparse.csv_parsing.entity.ProductEntity;
        import com.csvparse.csv_parsing.helper.ExcelHelper;
        import com.csvparse.csv_parsing.repository.ProductRepository;
        import org.springframework.stereotype.Service;
        import org.springframework.web.multipart.MultipartFile;
        
        import java.io.IOException;
        import java.io.InputStream;
        import java.util.List;
        
        @Service
        public class ProductService {
        
            private final ProductRepository productRepository;
        
            public ProductService(ProductRepository productRepository) {
                this.productRepository = productRepository;
            }
        
            public void saveProductList(MultipartFile file) {
                if (ExcelHelper.isValidExcelFile(file)) {
                    try (InputStream inputStream = file.getInputStream()) {
                        List<ProductEntity> productList = ExcelHelper.convertExcelToProductList(inputStream);
                        productRepository.saveAll(productList);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    throw new IllegalArgumentException("Invalid file format. Please upload a valid Excel file.");
                }
            }
        
            public List<ProductEntity> getAllProducts() {
                return productRepository.findAll();
            } 
        
        }
        
        ```
        

- Now we just need to create a Controller for this ProductEntity and then our parsing would be completed
    
    ```java
    package com.csvparse.csv_parsing.controller;
    
    import com.csvparse.csv_parsing.entity.ProductEntity;
    import com.csvparse.csv_parsing.service.ProductService;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    
    import java.util.List;
    
    @RestController
    @RequestMapping("/api/products")
    public class ProductController {
    
        private final ProductService productService;
    
        public ProductController(ProductService productService) {
            this.productService = productService;
        }
    
        @PostMapping("/upload")
        public ResponseEntity<List<ProductEntity>> uploadProductFile(@RequestParam("file") MultipartFile file) {
            try {
                List<ProductEntity> productList = productService.saveProductList(file);
                return new ResponseEntity<>(productList, HttpStatus.CREATED);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    
        @GetMapping("/all")
        public ResponseEntity<List<ProductEntity>> getAllProducts() {
            List<ProductEntity> productList = productService.getAllProducts();
            return new ResponseEntity<>(productList, HttpStatus.OK);
        }
    }
    
    ```
    

- Now if we go to Postman and create a POST request to the url “http://localhost:8080/api/products/upload” and send the csv file as input then it would be stored in our db
    
    ![image.png](/images/csv/image%206.png)
    
    ![image.png](/images/csv/image%207.png)