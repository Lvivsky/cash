<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header dark-bg">
    <div class="toggle-nav">
        <div class="icon-reorder tooltips" data-original-title="Toggle Navigation" data-placement="bottom"><i class="icon_menu"></i></div>
    </div>

    <!--logo start-->
    <a href="/" class="logo">Ca<span class="lite">s</span>h</a>
    <!--logo end-->

    <div class="nav search-row" id="top_menu">
        <!--  search form start -->
        <ul class="nav top-menu">
            <li>
                <form class="navbar-form">
                    <input class="form-control" placeholder="Search" type="text">
                </form>
            </li>
        </ul>
        <!--  search form end -->
    </div>


            <div class="top-nav notification-row">

                <ul class="nav pull-right top-menu">

<%--                    --%>
<%--&lt;%&ndash;                    &ndash;%&gt;--%>
<%--                    <li id="task_notificatoin_bar" class="dropdown">--%>
<%--                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">--%>
<%--                            <i class="icon-task-l"></i>--%>
<%--                            <span class="badge bg-important">6</span>--%>
<%--                        </a>--%>
<%--                        <ul class="dropdown-menu extended tasks-bar">--%>
<%--                            <div class="notify-arrow notify-arrow-blue"></div>--%>
<%--                            <li><p class="blue">You have 6 pending letter</p></li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <div class="task-info">--%>
<%--                                        <div class="desc">Design PSD </div>--%>
<%--                                        <div class="percent">90%</div>--%>
<%--                                    </div>--%>
<%--                                    <div class="progress progress-striped">--%>
<%--                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%">--%>
<%--                                            <span class="sr-only">90% Complete (success)</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <div class="task-info">--%>
<%--                                        <div class="desc">--%>
<%--                                            Project 1--%>
<%--                                        </div>--%>
<%--                                        <div class="percent">30%</div>--%>
<%--                                    </div>--%>
<%--                                    <div class="progress progress-striped">--%>
<%--                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="30" aria-valuemin="0" aria-valuemax="100" style="width: 30%">--%>
<%--                                            <span class="sr-only">30% Complete (warning)</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </a>--%>
<%--                            </li>--%>


<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <div class="task-info">--%>
<%--                                        <div class="desc">Digital Marketing</div>--%>
<%--                                        <div class="percent">80%</div>--%>
<%--                                    </div>--%>
<%--                                    <div class="progress progress-striped">--%>
<%--                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">--%>
<%--                                            <span class="sr-only">80% Complete</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <div class="task-info">--%>
<%--                                        <div class="desc">Logo Designing</div>--%>
<%--                                        <div class="percent">78%</div>--%>
<%--                                    </div>--%>
<%--                                    <div class="progress progress-striped">--%>
<%--                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="78" aria-valuemin="0" aria-valuemax="100" style="width: 78%">--%>
<%--                                            <span class="sr-only">78% Complete (danger)</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <div class="task-info">--%>
<%--                                        <div class="desc">Mobile App</div>--%>
<%--                                        <div class="percent">50%</div>--%>
<%--                                    </div>--%>
<%--                                    <div class="progress progress-striped active">--%>
<%--                                        <div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%">--%>
<%--                                            <span class="sr-only">50% Complete</span>--%>
<%--                                        </div>--%>
<%--                                    </div>--%>

<%--                                </a>--%>
<%--                            </li>--%>

<%--                            <li class="external">--%>
<%--                                <a href="#">See All Tasks</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>

<%--&lt;%&ndash; Messages &ndash;%&gt;--%>

<%--                    <li id="mail_notificatoin_bar" class="dropdown">--%>
<%--                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">--%>
<%--                            <i class="icon-envelope-l"></i>--%>
<%--                            <span class="badge bg-important">5</span>--%>
<%--                        </a>--%>
<%--                        <ul class="dropdown-menu extended inbox">--%>
<%--                            <div class="notify-arrow notify-arrow-blue"></div>--%>
<%--                            <li>--%>
<%--                                <p class="blue">You have 5 new messages</p>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <span class="photo"><img alt="avatar" src="../../resources/img/avatar-mini.jpg"></span>--%>
<%--                                    <span class="subject">--%>
<%--                                    <span class="from">Greg  Martin</span>--%>
<%--                                    <span class="time">1 min</span>--%>
<%--                                    </span>--%>
<%--                                    <span class="message">--%>
<%--                                        I really like this admin panel.--%>
<%--                                    </span>--%>
<%--                                </a>--%>
<%--                            </li>--%>

<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">See all messages</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>

<%--&lt;%&ndash; Notification &ndash;%&gt;--%>

<%--                    <li id="alert_notificatoin_bar" class="dropdown">--%>
<%--                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">--%>

<%--                            <i class="icon-bell-l"></i>--%>
<%--                            <span class="badge bg-important">7</span>--%>
<%--                        </a>--%>
<%--                        <ul class="dropdown-menu extended notification">--%>
<%--                            <div class="notify-arrow notify-arrow-blue"></div>--%>
<%--                            <li>--%>
<%--                                <p class="blue">You have 4 new notifications</p>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <span class="label label-primary"><i class="icon_profile"></i></span>--%>
<%--                                    Friend Request--%>
<%--                                    <span class="small italic pull-right">5 mins</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <span class="label label-warning"><i class="icon_pin"></i></span>--%>
<%--                                    John location.--%>
<%--                                    <span class="small italic pull-right">50 mins</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <span class="label label-danger"><i class="icon_book_alt"></i></span>--%>
<%--                                    Project 3 Completed.--%>
<%--                                    <span class="small italic pull-right">1 hr</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">--%>
<%--                                    <span class="label label-success"><i class="icon_like"></i></span>--%>
<%--                                    Mick appreciated your work.--%>
<%--                                    <span class="small italic pull-right"> Today</span>--%>
<%--                                </a>--%>
<%--                            </li>--%>
<%--                            <li>--%>
<%--                                <a href="#">See all notifications</a>--%>
<%--                            </li>--%>
<%--                        </ul>--%>
<%--                    </li>--%>


<%-- User dropdoun --%>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="profile-ava">
                                <i class="icon-task-l"></i>
                            </span>
                            <span class="username"> File </span>
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu extended logout">
                            <div class="log-arrow-up"></div>
                            <li class="eborder-top"><a href="/save"><i class="icon_profile"></i> Save </a></li>
                            <li><a href="/remove-db"><i class="icon_clock_alt"></i> Out</a></li>
<%--                            <li><a href="#"><i class="icon_chat_alt"></i> Chats</a></li>--%>
                        </ul>
                    </li>
                </ul>
            </div>






</header>
<!--header end-->