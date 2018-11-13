<%-- 
    Document   : index
    Created on : 23.03.2018, 9:27:17
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>

<div id="appLdap" class="row">
    <div class="col-sm-6">
        <div class="panel panel-green">
            <div class="panel-heading">
                
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-12">
                        <hr />
                        <form class="form-horizontal">
                            <div class="form-group">
                                <label for="givenName" class="col-sm-2">Имя</label>
                                <div class="col-sm-10">
                                    <input type="text" required class="form-control" v-model="givenName" id="givenName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="sn" class="col-sm-2">Фамилия</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" v-model="sn" id="sn" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="displayName" class="col-sm-2">Выводимое имя</label>
                                <div class="col-sm-10">
                                    <input type="text" required class="form-control" readonly v-model="container.contact.displayName" id="displayName" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="description" class="col-sm-2">Описание</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" readonly v-model="container.contact.description" id="description" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="telephoneNumber" class="col-sm-2">Телефон</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" v-model="container.contact.telephoneNumber" id="telephoneNumber" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="mail" class="col-sm-2">Эл. почта</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" v-model="container.contact.mail" id="mail" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="post" class="col-sm-2">Должность</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" v-model="post" id="post" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="company" class="col-sm-2">Организация</label>
                                <div class="col-sm-10">
                                  <input type="text" required class="form-control" v-model="company" id="company" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="region" class="col-sm-2">Регион</label>
                                <div class="col-sm-10">
                                  <input type="text" pattern="\d*" title="Только цифры" required class="form-control" v-model="region" id="region" />
                                </div>
                            </div>
                            <button @click.prevent="save" class="btn btn-success">Сохранить</button> <a href="/phones/ldap/contact" class="btn btn-success">Назад</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>        

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>
<script type="text/javascript">
    
    var appLdap = new Vue({
        el: "#appLdap",
        data:{
            givenName: "",
            sn: "",
            post: "",
            company: "",
            region: "",
            error: "",
            container:{
                contact:{
                    givenName: "",
                },
            }
        },
        methods: {
            save:function(){
                axios.post("/phones/ldap/ajax/contact/add", this.container.contact)
                .then(resp=>{
                    $.notify(resp.data.answer);
                })
                .catch(resp=>{
                    $.notify(resp.data.answer);
                });
            }
        },
        watch:{
            givenName: function (){
                this.container.contact.givenName = this.givenName; 
                this.container.contact.displayName = this.container.contact.sn +" "+ this.container.contact.givenName;            
            },
            post: function (){
                this.container.contact.post = this.post; 
                this.container.contact.description = this.region+" "+this.container.contact.company +" "+ this.container.contact.post;            
            },
            company: function (){
                this.container.contact.company = this.company; 
                this.container.contact.description = this.region+" "+this.container.contact.company +" "+ this.container.contact.post;            
            },
            region: function (){
                this.container.contact.description = this.region+" "+this.container.contact.company +" "+ this.container.contact.post;            
            },
            
            sn: function (){
                this.container.contact.sn = this.sn;
                this.container.contact.displayName = this.container.contact.sn + " "+this.container.contact.givenName;            
            }
        }
        
    });
</script>