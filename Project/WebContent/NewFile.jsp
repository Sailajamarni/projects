<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Display</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Font Awesome for icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <!-- Custom CSS -->
    <style>
        /* Custom styles for product cards */
        .product-card {
            border: 1px solid #ddd;
            border-radius: 8px;
            margin-bottom: 20px;
            width: 300px; /* Fixed width for product cards */
        }

        .product-card .card-img-top {
            height: 200px; /* Set height for product image */
            object-fit: cover;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }

        .product-card .card-body {
            padding: 15px;
        }

        .product-card .card-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .product-card .card-text {
            font-size: 16px;
            margin-bottom: 10px;
        }

        .product-card .btn-primary {
            width: 100%;
            background-color: #007bff;
            border-color: #007bff;
        }

        /* Styling for category and price dropdowns */
        #category, #price {
            width: 150px;
            margin-right: 10px;
        }

        /* Cart icon style */
        #cartIcon {
            position: fixed;
            top: 20px;
            right: 20px;
            font-size: 24px;
            color: #007bff; /* Blue color for cart icon */
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="my-4">Products</h2>
        <div class="row">
            <div class="col-md-4">
                <select id="category" class="form-control">
                    <option value="0">All Categories</option>
                    <option value="1">Mobiles</option>
                    <option value="2">Clothes</option>
                </select>
            </div>
            <div class="col-md-4">
                <select id="price" class="form-control">
                    <option value="0">Max Price</option>
                    <option value="1000">Up to 1000</option>
                    <option value="5000">Up to 5000</option>
                    <option value="10000">Up to 10000</option>
                    <option value="20000">Up to 20000</option>
                    <option value="30000">Up to 30000</option>
                    <option value="40000">Up to 40000</option>
                    <option value="50000">Up to 50000</option>
                </select>
            </div>
        </div>
        <div class="row mt-4" id="products">
            <!-- Product cards will be dynamically added here -->
        </div>
    </div>

    <!-- Cart icon at the top right corner -->
    <i id="cartIcon" class="fas fa-shopping-cart"></i>

    <!-- Bootstrap JS and jQuery -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>

    <script>
        $(document).ready(function(){
            // Handle category change
            $("#category").change(function(){
                var categoryId = $(this).val();
                loadProducts(categoryId, null);
            });

            // Handle price range change
            $("#price").change(function(){
                var categoryId = $("#category").val();
                var priceId = $(this).val();
                loadProducts(categoryId, priceId);
            });

            // Function to load products via AJAX
            function loadProducts(categoryId, priceId) {
                $.ajax({
                    url: "ProductsServlet",
                    method: "POST",
                    data: { category: categoryId, price: priceId },
                    success: function(data) {
                        $("#products").empty();
                        $.each(data, function(index, product) {
                            var card = $("<div>").addClass("card product-card");
                            var cardBody = $("<div>").addClass("card-body");
                            var productImage = $("<img>").addClass("card-img-top").attr("src", product.imgpath);
                            var productName = $("<h5>").addClass("card-title").text(product.name);
                            var productPrice = $("<p>").addClass("card-text").text("Price: " + product.price);
                            var addToCartButton = $("<button>").addClass("btn btn-primary").text("Add to Cart");

                            addToCartButton.click(function() {
                                $.ajax({
                                    url: "CartServlet",
                                    method: "POST",
                                    data: { productId: product.id },
                                    dataType: "text",
                                    success: function(response) {
                                        alert("Item Added to Cart!");
                                    },
                                    error: function(xhr, status, error) {
                                        console.error("Error adding product to cart:", error);
                                    }
                                });
                            });

                            cardBody.append(productImage, productName, productPrice, addToCartButton);
                            card.append(cardBody);
                            $("#products").append(card);
                        });
                    }
                });
            }

            // Redirect to cartdisplay.jsp when cart icon is clicked
            $("#cartIcon").click(function() {
                window.location.href = "cartdisplay.jsp";
            });
        });
    </script>
</body>
</html>
