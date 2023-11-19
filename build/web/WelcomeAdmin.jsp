<%-- 
    Document   : patient_login
    Created on : 6 Jul, 2022, 7:37:44 PM
    Author     : user
--%>

<%@page import="SCHpackage.Message"%>
<%@page import="SCHpackage.PatientModel"%>
<%@page import="SCHpackage.MedicalCard"%>
<%@page import="SCHpackage.doctorModel"%>
<%@page import="SCHpackage.AdminData"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<AdminData> data=(ArrayList<AdminData>)request.getAttribute("adminlist");
    ArrayList<MedicalCard> cardList=(ArrayList<MedicalCard>)request.getAttribute("cList");
    ArrayList<PatientModel> pList=(ArrayList<PatientModel>)request.getAttribute("patientList");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Welcome Page</title>
        <!-- slider stylesheet -->
  <link rel="stylesheet" type="text/css"
    href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css?family=Poppins:400,600,700|Roboto:400,700&display=swap" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />    
  <link href="css/tableStyles.css" rel="stylesheet" type="text/css"/>
    </head>
    
    
    <body>
        
    <!---------------------------------------------------------------------------------------------------------------------->    
    <div class="hero_area">
    <!-- header section strats -->
    <header class="header_section">
      <div class="container">
        <div class="top_contact-container">
          <div class="tel_container">
            <a href="">
              <img src="images/telephone-symbol-button.png" alt=""> 
            </a>
          </div>
          <div class="social-container">
            <a href="">
              <img src="images/fb.png" alt="" class="s-1">
            </a>
            <a href="">
              <img src="images/twitter.png" alt="" class="s-2">
            </a>
            <a href="">
              <img src="images/instagram.png" alt="" class="s-3">
            </a>
          </div>
        </div>
      </div>
      <div class="container-fluid">
        <nav class="navbar navbar-expand-lg custom_nav-container pt-3">
          <a class="navbar-brand" href="index.html">
            <img src="images/logo.png" alt="">
            <span>
              RHC
            </span>
          </a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <div class="d-flex  flex-column flex-lg-row align-items-center w-100 justify-content-between">
              <ul class="navbar-nav  ">
                <li class="nav-item active">
                  <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="about.jsp"> About </a>
                </li>
                 <li class="nav-item">
                  <a class="nav-link" href="doctorRegistration.jsp"> Doctor Registration </a>
                </li>
                <li>
                    <p>
                    <h6>
                        <b style="color: yellow">Admin Email  :  </b>
                    </h6>
                    </p>
                </li>
                <li>
                    <p>
                    <h6>
                            <%
                        for(AdminData ad:data){
                            %>
                            <b style="color: red"><%=ad.getEmail()%></b>
                               
                        <%
                        }
                        %>
                       
                    </h6>
                    </p>
                </li>
                
               
              </ul>
              
                
              
             
             
            </div>
          </div>

        </nav>
      </div>
    </header>
    <!-- end header section -->
  
    <!-- slider section -->
    <section class=" slider_section position-relative">
      <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <!--ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol -- >
        <div class="carousel-inner">
          <div class="carousel-item active">
            <div class="container">
              <div class="row">
                <div class="col-md-4">
                  <div class="img-box">
                    <img src="images/medicine.png" alt="">
                  </div>
                </div>
                  
                  <!--------WELCOME to OUR SHC option ----------------->
                  <div class="row">   
                  <div class="col-md-4">
                  <div class="img-box">
                    <img src="images/medicine.png" alt="">
                  </div>
                </div>
            
                <center>
                    <form method="post" >
                    <table id="patient">
                        <tr>
                            <th>
                                Email
                            </th>
                            <th>
                                Name
                            </th>
                            <th>
                                Gender
                            </th>
                            <th>
                                Registration Date
                            </th>
                            <th>
                                Patient Details
                            </th>
                        </tr>
                        <%
                        for(PatientModel p:pList){
                            %>
                            <tr>
                                <td>
                                    <%=p.getEmail()%>
                                    <input type="hidden" name="tb_email" value="<%=p.getEmail()%>">
                                </td>
                                <td>
                                    <%=p.getName()%>
                                </td>
                                <td>
                                    <%=p.getGender()%>
                                </td>
                                <td>
                                    <%=java.time.LocalDate.now().toString()%>
                                </td>
                                <td>
                                    <button type="submit" class="button1" formaction="patientDetailsforAdmin2?id=<%=p.getEmail()%>">Proceed</button>
                                    
                                </td>
                                
                            </tr>
                        <%
                        }
                        %>
                        <%
                                    if(request.getAttribute("message")!=null){
                                        Message msg=(Message)request.getAttribute("message");
                                        %>
                                        <tr>
                                        <td colspan="2">
                                            <label style="color: red"><b><%=msg.getMsg()%></b></label>
                                        </td>
                                        </tr>
                                <%
                                    }
                                %>
                    </table>
                    
                    </form>
                    
                </center>
            
                      
                      
                  </div>
            </div>
        
    </section>
 </div>
 <!--------end of WELCOME to OUR SHC option ----------------->
              
  <!-- info section -->
  <section class="info_section layout_padding2">
    <div class="container">
      <div class="row">
        <div class="col-md-3">
          <div class="info_contact">
            <h4>
              Contact
            </h4>
            <div class="box">
              <div class="img-box">
                <img src="images/telephone-symbol-button.png" alt="">
              </div>
              <div class="detail-box">
                <h6>
                  +91 7438012841 </h6>
              </div>
            </div>
            <div class="box">
              <div class="img-box">
                <img src="images/email.png" alt="">
              </div>
              <div class="detail-box">
                <h6>
                  chinmayadnr2018@gmail.com
                </h6>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-3">
          <div class="info_menu">
            
          </div>
        </div>
        <div class="col-md-6">
          <div class="info_news">
            <h4>
              newsletter
            </h4>
            <form action="">
              <input type="text" placeholder="Enter Your email">
              <div class="d-flex justify-content-center justify-content-end mt-3">
                <button>
                  Subscribe
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </section>


  <!-- end info section -->
          
                
                
                <!-- footer section -->
  <section class="container-fluid footer_section">
    <p>
      &copy; 2022 All Rights Reserved. Design by
      <a href="https://html.design/">Team Northropio </a>
    </p>
  </section>
  <!-- footer section -->
                
              <!--/div--> <!--my div-->
            </div> <!--my div for patient login -->
  <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.2.1/owl.carousel.min.js">
  </script>
  <script type="text/javascript">
    $(".owl-carousel").owlCarousel({
      loop: true,
      margin: 10,
      nav: true,
      navText: [],
      autoplay: true,
      responsive: {
        0: {
          items: 1
        },
        600: {
          items: 2
        },
        1000: {
          items: 4
        }
      }
    });
  </script>
  <script type="text/javascript">
    $(".owl-2").owlCarousel({
      loop: true,
      margin: 10,
      nav: true,
      navText: [],
      autoplay: true,

      responsive: {
        0: {
          items: 1
        },
        600: {
          items: 2
        },
        1000: {
          items: 4
        }
      }
    });
  </script>              
                
            
    </body>
</html>
