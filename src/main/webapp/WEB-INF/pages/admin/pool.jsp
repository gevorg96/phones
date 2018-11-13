<%-- 
    Document   : index.jsp
    Created on : 21.03.2017, 18:16:16
    Author     : trunov_as
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<style type="text/css">
    
</style>

    <!-- /.row -->
    <div id="appPull" class="container-fluid">
        
            
        
        <div class="row">
            <div class="col-xs-4">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <h3 class="panel-title">Новый пул номеров</h3>
                    </div>
                    <div class="panel-body">
                        <form>
                            <div class="form-group">
                                <label for="type">Тип пула</label>
                                <select class="form-control" id="type" placeholder="">
                                    <option v-for="ct in contacttype" value="{{ct.id}}">{{ct.name}}</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label for="name">Название пула</label>
                                <input type="text" class="form-control" id="name" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="start">Начало диопазона пула</label>
                                <input type="text" class="form-control" id="start" placeholder="">
                            </div>
                            <div class="form-group">
                                <label for="end">Конец диопазона пула</label>
                                <input type="text" class="form-control" id="end" placeholder="">
                            </div>
                             <div class="form-group">
                                <label for="comment">Коментарий</label>
                                <input type="text" class="form-control" id="comment" placeholder="">
                            </div>
                            <input type="submit" class="btn btn-default" value="Создать диопазон">
                        </form>
                    </div>
                </div>
                
            </div>
            <div class="col-xs-6">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <h3 class="panel-title">Список созданых пулов</h3>
                    </div>
                    <div class="panel-body">
                        <table class="table">
                            <thead>
                                <th>Название пула</th>
                                <th>Диапазон пула</th>
                                <th>Коментарий</th>
                                <th colspan="1">Операции</th>
                            </thead>
                            <tbody>
                                <tr v-for="pool in pools">
                                    <td>{{pool.poolname}}</td>
                                    <td>{{pool.lowbound}} - {{pool.highbound}}</td>
                                    <td>{{pool.commentaries}}</td>
                                    <td>Удалить</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <div class="panel panel-yellow">
                    <div class="panel-heading">
                        <h3 class="panel-title">Выбрать пул</h3>
                    </div>
                    <div class="panel-body">
                        <form>
                            <div class="form-group">
                                <select class="form-control" @change="changePool" v-model="selectedPool">
                                    <option v-for="pool in pools" :value="pool.id">{{pool.poolname}} {{pool.lowbound}} - {{pool.highbound}}</option>
                                </select>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <h2 class="text-center">Пул номеров</h2>
            </div>
        </div>
        
        <div v-for="contact in contacts" >
                <div v-bind:class="contact.free">
                    <div>{{contact.name}}{{contact.append}}</div>
                    <a v-bind:href="'/phones/contact/log/'+contact.name">
                        <span class="">Посмотреть лог изменений</span>
                    </a>
                </div>
                <hr />
        </div>
    </div>
    <!-- /.row -->

<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>
<script>
    var appPull = new Vue({
            el: "#appPull",
            data:{
               viewPull:[],
               pools:[],
               selectedPool: '',
               contacttype:[],
               contacts:[]
           },
           methods:{
               changePool: function(){
                   axios.get("pool/ajax/"+this.selectedPool).then(
                       request=>{
                           if (request.data.length>0){
                                this.contacts =
                                    request.data.map(function(item){
                                        if (item.id == 0){
                                            return {"name": item.contact,"append":" - свободен", "free": "panel-green"}
                                        }else {
                                            return {"name": item.contact, "append":" - занят", "free": "panel-red"}
                                        }
                                            
                                    });
                            }
                        }
                )
                .catch(
                    err=>{
                        console.log(err);
                    }
                );
               }
           },
           created(){
               axios.get("pool/ajax/list").then(
                       request=>{
                           this.pools = request.data;
                       }
                )
                .catch(
                    err=>{
                        console.log(err);
                    }
                );
        
                axios.get("contacttype/ajax/list").then(
                       request=>{
                           this.contacttype = request.data;
                       }
                )
                .catch(
                    err=>{
                        console.log(err);
                    }
                );
               
           }
        }); 
    
</script>