<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<title>SignUp</title>
</head>
<body>
 <style>body {
        color: #000;
        overflow-x: hidden;
        height: 100%;
        background-color: #B0BEC5;
        background-repeat: no-repeat;
    }
    
    .card0 {
        box-shadow: 0px 4px 8px 0px #757575;
        border-radius: 0px;
    }
    
    .card2 {
        margin: 0px 40px;
    }
    
    .logo {
        width: 200px;
        height: 100px;
        margin-top: 20px;
        margin-left: 35px;
    }
    
    .image {
        width: 360px;
        height: 280px;
    }
    
    .border-line {
        border-right: 1px solid #EEEEEE;
    }
    
    
    .or {
        width: 10%;
        font-weight: bold;
    }
    
    .text-sm {
        font-size: 14px !important;
    }
    
    ::placeholder {
        color: #BDBDBD;
        opacity: 1;
        font-weight: 300
    }
    
    :-ms-input-placeholder {
        color: #BDBDBD;
        font-weight: 300
    }
    
    ::-ms-input-placeholder {
        color: #BDBDBD;
        font-weight: 300
    }
    
    input, textarea {
        padding: 10px 12px 10px 12px;
        border: 1px solid lightgrey;
        border-radius: 2px;
        margin-bottom: 5px;
        margin-top: 2px;
        width: 100%;
        box-sizing: border-box;
        color: #2C3E50;
        font-size: 14px;
        letter-spacing: 1px;
    }
    
    input:focus, textarea:focus {
        -moz-box-shadow: none !important;
        -webkit-box-shadow: none !important;
        box-shadow: none !important;
        border: 1px solid #ff6a00;
        outline-width: 0;
    }
    
    button:focus {
        -moz-box-shadow: none !important;
        -webkit-box-shadow: none !important;
        box-shadow: none !important;
        outline-width: 0;
    }
    
    a {
        color: inherit;
        cursor: pointer;
    }
    
    .btn-blue {
        background-color: #ff5e00;
        width: 150px;
        color: #fff;
        border-radius: 2px;
    }
    
    .btn-blue:hover {
        background-color: #ffffff;
        cursor: pointer;
        color: #ff5e00;
    }
    
    .bg-blue {
        color: #fff;
        background-color: #ff7b00;
    }
    
    @media screen and (max-width: 991px) {
        .logo {
            margin-left: 0px;
        }
    
        .image {
            width: 300px;
            height: 220px;
        }
    
        .border-line {
            border-right: none;
        }
    
        .card2 {
            border-top: 1px solid #EEEEEE !important;
            margin: 0px 15px;
        }
    }</style>
   <form method="post" action="signup" enctype="multipart/form-data">
    <div class="container-fluid px-1 px-md-5 px-lg-1 px-xl-5 py-5 mx-auto">
        <div class="card card0 border-0 ">
            <div class="row d-flex">
                <div class="col-lg-6">
                    <div class="card1 pb-5">
                        <div class="row" style="width: 30px;">
                            <img src="" class="logo">
                        </div>
                        <div class="row px-3 justify-content-center mt-4 mb-5 border-line">
                            <img src="https://epimaxsolutions.com/wp-content/uploads/Group-12192-1.png" class="image">
                        </div>
                    </div>
                </div>
                
                <div class="col-lg-6">
                    <div class="card2 card border-0 px-4 py-5">
                        <div class="row mb-4 px-3">
                        </div>
                        <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">
                                UserId</h6></label>
                            <input class="mb-4" type="text" placeholder="Enter a UserId" name="id">
                        </div> <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">
                                UserName</h6></label>
                            <input class="mb-4" type="text" name="name" placeholder="Enter a UserName">
                        </div> <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">
                                UserEmail</h6></label>
                            <input class="mb-4" type="text" name="mail" placeholder="Enter a UserEmail">
                        </div> <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">
                                UserContact</h6></label>
                            <input class="mb-4" type="text" name="contact" placeholder="Enter a UserContact">
                        </div>
                        <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">Password</h6></label>
                            <input type="password" name="pass" placeholder="Enter password">
                        </div>
                        <div class="row px-3">
                            <label class="mb-1"><h6 class="mb-0 text-sm">Image</h6></label>
                            <input type="file" name="userimage">
                        </div>
                        <div class="row px-3 mb-4">
                            <div class="custom-control custom-checkbox custom-control-inline">
                                <input id="chk1" type="checkbox" name="chk" class="custom-control-input"> 
                                <label for="chk1" class="custom-control-label text-sm">Remember me</label>
                            </div>
                            <a href="#" class="ml-auto mb-0 text-sm">Forgot Password?</a>
                        </div>
                        <div class="row mb-3 px-3">
                            <button type="submit" class="btn btn-blue text-center">Signup</button>
                        </div>
                       
                    </div>
                </div>
            </div>
            <div class="bg-blue py-4">
                <div class="row px-3">
                    <small class="ml-4 ml-sm-5 mb-2">Copyright &copy; 2024. All rights reserved.</small>
                   
                </div>
            </div>
        </div>
    </div></form>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></script>

</body>
</html>