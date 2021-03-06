
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Find For Me</title>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta content="width=device-width, initial-scale=1" name="viewport"/>
        <meta content="" name="description"/>
        <meta content="" name="author"/>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/default.css">
    </head>
    <body>
        <nav class="navbar navbar-default navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#mynavbar">
                        <span class="glyphicon glyphicon-list"></span>
                    </button>
                    <a ><img src="img/logo.PNG" class="img-responsive default-img"></a>
                </div>
                <div class="collapse navbar-collapse" id="mynavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="#">home</a></li>
                        <li><a href="#">hire freelancer</a></li>
                        <li><a href="#">find work</a></li>	
                        <li><a href="#">how it works</a></li>
                        <!--</ul>
                        <ul class="nav navbar-nav navbar-right">-->
                        |<li><a data-target="#mymodal" data-toggle="modal">sign in<span class="glyphicon glyphicon-log-in"></span></a></li>
                        <li><a data-target="#modal-signup" data-toggle="modal">sign up<span class="glyphicon glyphicon-user"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!---carousel-->
        <div class="conatainer-fluid">
            <div id="mycarousel" class="carousel slide" data-ride="carousel">
                <div class="carousel-indicators">
                    <li data-target="#mycarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#mycarousel" data-slide-to="1"></li>
                    <li data-target="#mycarousel" data-slide-to="2"></li>
                </div>
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="img/banner/1.jpeg" class="carousel-img" alt="banner1">
                        <div class="carousel-caption">
                            <div class="container row">
                                <div class="col-md-4 col-md-offset-2">
                                    <h3>Sign In <span class="glyphicon glyphicon-log-in"></span></h3>
                                    <div class="default-signin"></div>
                                    <h5>New User</h5>
                                    <button id="btn-create" data-target="#modal-signup"  data-toggle="modal" class="btn btn-default">Create Account</button>
                                </div>
                            </div>
                        </div>						
                    </div>
                    <div class="item">
                        <img src="img/banner/2.jpg" class="carousel-img" alt="banner1">
                        <div class="carousel-caption">
                            <div class="container row">
                                <div class="col-md-4 col-md-offset-2">
                                    <h3>Sign In <span class="glyphicon glyphicon-log-in"></span></h3>
                                    <div class="default-signin"></div>
                                    <h5>New User</h5>
                                    <button id="btn-create" data-target="#modal-signup"  data-toggle="modal" class="btn btn-default">Create Account</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="item">
                        <img src="img/banner/3.jpg" class="carousel-img" alt="banner1">
                        <div class="carousel-caption">
                            <div class="container row">
                                <div class="col-md-4 col-md-offset-2">
                                    <h3>Sign In <span class="glyphicon glyphicon-log-in"></span></h3>
                                    <div class="default-signin"></div>
                                    <h5>New User</h5>
                                    <button id="btn-create" data-target="#modal-signup"  data-toggle="modal" class="btn btn-default">Create Account</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#mycarousel" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">previous</span>
                </a>
                <a class="right carousel-control" href="#mycarousel" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">next</span>
                </a>
            </div>
        </div>
        <!--carousel end-->
        <!--content-->
        <h3 class="page-header" data-spy="affix" data-offset-top="355">Find For Me</h3>
        <div class="container">
            <div class="row">
                <div class="col-md-2">
                    <!---for side vword-->
                </div>
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-6">
                            <h3>Just One Click Away</h3>
                            <p>
                                Post your project and receive competitive bids from find for me within minutes.
                                Our reputation system will make it easy to find the perfect freelancer for your job.
                                It&#039;s the simplest and safest way to get work done online.
                            </p>
                            <p>
                                We have millions of Freelancers for thousands of freelance jobs:
                                from web design, mobile app development, virtual assistants, product manufacturing and graphic design.
                                Whatever your needs, there will be a freelancer to get it done.
                            </p>
                            <h3>How do you benefit?</h3>
                            <ul>
                                <li>You’ll receive bids for free from our talented freelancers within seconds.</li>
                                <li>Keeping up-to-date with our 24/7 support, time tracker, and mobile app.</li>
                                <li>Chat for free.</li>
                                <li>Browse samples of p</li>
                                <li>Only pay for the work when it is completed in a safe and secure manner. Release your payment when you are 100% satisfied with the work provided.</li>
                            </ul>
                        </div>
                        <div class="col-md-6">
                            <!--inside -->
                        </div>
                    </div>
                </div> 
                <div class="col-md-2">
                    <!--for right side-->
                </div>
            </div>
            <div class="row">
                <div class="c0l-md-4 col-md-offset-3">
                    <div class="search_category">
                        <h3>Search for Lables</h3><span class="glyphicon glyphicon-search"></span>
                        <input type="text" id="search_category" class="form-control" placeholder="Search for label">
                    </div>
                    <table class="table" id="search_table">
                        <tr>
                            <td>Website &amp; IT Software
                                <ul class="none">
                                    <li>a</li>
                                    <li>b</li>
                                    <li>c</li>
                                    <li>d</li>
                                    <li>e</li>
                                    <li>f</li>
                                    <li>g</li>
                                </ul>
                            </td>
                            <td>Mobie &amp; Computing</td>
                            <td>Writting &amp; Content</td>
                            <td>Design, Media &amp; Architechture</td>
                        </tr>
                        <tr>
                            <td>Data Entry &amp; Admin</td>
                            <td>Engineering &amp; Science</td>
                            <td>Product Sourcing &amp; Manufacturing</td>
                            <td>Sales &amp; Marketing</td>
                        </tr>
                        <tr>
                            <td>Bussiness, Accounting, Human Resource &amp; legal</td>
                            <td>Translating &amp; Langauge</td>
                            <td>Local Jobs &amp; Service</td>
                            <td>more...</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

        <!-- statr modal-->
        <div class="modal fade" role="dialog" id="mymodal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Sign In</h3>
                    </div>
                    <div class="modal-body" id="default-signin-modal">
                        <form action="#">
                            <div class="form-group">
                                <label for="uname">Username</label>
                                <input type="text" id="uname" class="form-control" placeholder="Enter Username">
                            </div>
                            <div class="form-group">
                                <label for="upass">Password <span class="glyphicon glyphicon-eye-close default-eye"></span></label>
                                <input type="password" id="upass" class="default-pass form-control" placeholder="Enter Password">
                            </div>
                            <button type="button" class="btn btn-default" id="b_signin">sign in</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-default" data-dismiss="modal">close</button>
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="modal-signup" role="dialog">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h3 class="modal-title">Create Account</h3>
                    </div>
                    <div class="modal-body" id="default-signup-modal">
                        <form action="#">
                            <div class="form-group">
                                <label for="username">Username</label>
                                <input type="text" id="username" class="form-control" placeholder="Username">
                            </div>
                            <div class="form-group">
                                <label for="email">Email Id</label>
                                <input type="text" id="email" class="form-control" placeholder="Email Address">
                            </div>
                            <div class="form-group">
                                <label for="mobile">Mobile No.</label>
                                <input type="text" id="mobile" class="form-control" placeholder="Mobile No.">
                            </div>
                            <div class="form-group">
                                <label for="password">Password</label>
                                <input type="text" id="password" class="form-control" placeholder="Password">
                            </div>
                            <div class="form-group">
                                <label for="repassword">Confirm Password</label>
                                <input type="text" id="repassword" class="form-control" placeholder="Confirm Password">
                            </div>
                            <hr><h4>captch code</h4>
                            <button class="btn btn-default" id="btn-signup">Create Account</button>
                            <button class="btn btn-default" type="reset">Reset</button>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <button type="button" data-dismiss="modal"class="btn btn-default">close</button>
                    </div>
                </div>
            </div>
        </div>
        <!--end modal-->
        <!-- footer -->
        <footer class="footer">
            <div class="">
                <h3>Find For Me</h3>
            </div>
        </footer>

        <script type="text/javascript" src="js/jquery-3.2.1.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/default.js"></script>
</body>
</html>