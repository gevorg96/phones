<%-- 
    Document   : add
    Created on : 22.03.2017, 13:43:43
    Author     : trunov_as
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/pages/admin/header.jsp" %>
<style type="text/css">
    .editRoom{
        border:none;
    }
</style>
<div id="appPersonUpdate" class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-green">
                <div class="panel-heading">
                    Редактирование контактов
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-8">
                            <div class="row">
                                <div class="col-sm-12">
                                    <div class="row">
                                        <div class="col-sm-4">
                                            <img class="img-responsive" v-bind:src="image">
                                        </div>
                                        <div class="col-sm-8">
                                            <div><strong>ФИО:</strong> {{data.person.surname}} {{data.person.name}} {{data.person.middlename}}</div> <br />
                                            <div v-if="data.person.job != null"><strong>Должность:</strong> {{data.person.job.name}}</div> <br />
                                            <div><strong>Подразделение:</strong> {{data.person.organization.name}}</div> <br />
                                            <div><strong>Комнаты:</strong> <span v-for="room in rooms">{{room.room}} </span></div> <br />
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Примечание:</label>
                                                <div class="col-sm-6">
                                                    <textarea class="form-control" v-model="data.person.note"></textarea>
                                                </div>
                                            </div>  <br /><br /> <br />
                                            <div class="form-group">
                                                <div class="col-sm-offset-2 col-sm-10">
                                                    <div class="pretty p-default p-curve p-thick p-smooth">
                                                        <input type="checkbox" v-model="fired" value="2" />
                                                        <div class="state p-danger-o">
                                                            <label>Уволен</label>
                                                        </div>
                                                    </div>
                                                    <div class="pretty p-default p-curve p-thick p-smooth">
                                                        <input type="checkbox" v-model="babyCare" value="1" />
                                                        <div class="state p-warning">
                                                            <label>Декрет</label>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div> <br /> <br />
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Группа:</label>
                                                <div class="col-sm-6">
                                                    <input class="form-control" v-model="data.person.contactGroup" type="text" />
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>
                            <br />
                            <div class="row">
                                <div class="col-sm-2">
                                    <strong>Основной контакт: </strong>
                                </div>
                                <div class="col-sm-6">
                                    <span v-for="maincontact in data.person.contacts" v-if="maincontact.rank == 1">{{maincontact.contact}}</span>
                                </div>
                            </div><br /><br />
                            <div class="row">
                                <div class="col-sm-12">
                                    <ul class="nav nav-tabs">
                                        <li v-bind:class="contact.active" v-for="contact in contacts">
                                            <a data-toggle="tab" v-bind:data-target="contact.ref">
                                                <input class="editRoom" @blur="notEditable" @dblclick="editable" readonly="readonly" type="text" v-model="contact.room" v-bind:value="contact.room" /><span class="glyphicon glyphicon-pencil form-control-feedback"></span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <br />
                            <div class="tab-content">
                                <div v-bind:class="contact.cls" v-for="contact in contacts" v-bind:id="contact.room">
                                    <div class="form-group" v-for="cont in contact.list">
                                        <label class="col-sm-2 col-form-label">{{cont.type.name}}</label>
                                        <div class="col-sm-8">
                                            <input class="form-control" type="text" v-model="cont.contact" />
                                        </div>
                                        <a v-bind:href="cont.id" v-bind:class="contact.room" v-on:click.prevent="deleteNumber"><span class="text-danger glyphicon glyphicon-remove"></span></a>
                                        <div v-if="cont.rank == 1" class="pretty p-switch">
                                            <input type="radio" name="mainBox" @click="changeMainContact" checked="checked" v-bind:value="cont.id" />
                                            <div class="state p-success">
                                                <label> </label>
                                            </div>
                                        </div>
                                        <div v-else class="pretty p-switch">
                                            <input type="radio" name="mainBox" @click="changeMainContact" v-bind:value="cont.id" />
                                            <div class="state p-success">
                                                <label> </label>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            <div><input class="btn btn-primary" type="submit" value="Сохранить" @click.prevent="save" /></div>
                        </div>
                        <div class="col-sm-4">
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                   Добавить комнату 
                                </div>
                                <div class="panel-body">
                                    <div class="col-sm-6">
                                       <input type="text" class="form-control" v-model="newRoom" /> 
                                    </div>
                                    <input type="submit" value="Добавить" @click.prevent="addRoom" class="btn btn-primary">
                                </div>
                            </div>
                            
                            <div class="panel panel-green">
                                <div class="panel-heading">
                                   Добавить контакт 
                                </div>
                                <div class="panel-body">
                                    <div class="col-sm-3">
                                        <label>Комната:</label>
                                        <select class="form-control" v-model="newContact.room">
                                            <option v-bind:value="room.room" v-for="room in rooms">{{room.room}}
                                        </select>
                                    </div>
                                    <div class="col-sm-3">
                                        <label>Пул:</label>
                                    <select v-model="selectedPool" class="form-control"> 
                                        <option v-bind:value="pool" v-for="pool in pools">{{pool.poolname}}</option>
                                    </select>
                                    </div>
                                    <div class="col-sm-3">
                                        <label>Контакт:</label>
                                        <select v-model="newContact.contact" class="form-control"> 
                                            <option v-bind:value="fcontact" v-for="fcontact in freeContacts">{{fcontact.contact}}</option>
                                        </select>
                                    </div>
                                    <div class="col-sm-2">
                                        <label style="color:white">Добавить</label>
                                        <input type="submit" class="btn btn-primary" @click.prevent="addContact" value="Добавить" />
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 
                </div>
            </div>
        </div>
    </div>



<%@ include file="/WEB-INF/pages/admin/footer.jsp" %>
<script>
    var router = new VueRouter({
        mode: 'history',
        routes: []
    });
    
    var appPersonUpdate = new Vue({
        router: router,
        el: "#appPersonUpdate",
        data:{
            data:{},
            image: '',
            rooms:[],
            newContact:{
                room: '',
                contact: '',
            },
            newRoom: '',
            fired: false,
            babyCare: false,
            mainContact: '',
            contacts:[
            ],
            deletedContacts:[],
            pools:[],
            selectedPool: {},
            freeContacts:[],
                
        },
        methods:{
            editable: function (event){
               event.target.removeAttribute("readonly");
            },
            notEditable: function (event){
               event.target.setAttribute("readonly","readonly");
            },
            deleteNumber: function(event){
                
                var delContact = event.target.parentNode.getAttribute("href");
                this.deletedContacts.push(delContact);
                event.target.parentNode.parentNode.remove();
                
                var room = event.target.parentNode.getAttribute("class");
                var indx = _.findIndex(this.contacts, ['room', room]);
                _.remove(this.contacts[indx].list, function(n){
                    console.log(delContact+ "==" + n.id);
                    return n.id == delContact;
                })
                
            },
            addRoom: function(){
                this.rooms.push({'room': this.newRoom});
                this.rooms = _.uniqBy(this.rooms,"room");
                
            },
            addContact: function(){
                    var room = this.newContact.room;
                    this.newContact.contact.room = room;
                    this.newContact.contact.type = this.selectedPool.phonetype;
                    var inx = _.findIndex(this.contacts, function(o){return o.room == room;});
                    if (inx == -1){
                       this.contacts.push({'room': this.newContact.room, 'list': [this.newContact.contact], "active":"", "ref": "#"+_.escapeRegExp(this.newContact.room), "cls": "tab-pane fade"}); 
                    } else {
                        this.contacts[inx].list.push(this.newContact.contact);
                    }
            },
            save:function(){
                axios.put("/phones/person/ajax/update/",this.data.person)
                .then(resp=>{
                    $.notify("Информация о пользователе обновлена", resp.data);
                })
                .then(
                    this.saveContacts.bind(this)
                ).then(
                    Promise.all(this.deletedContacts.map(function(item){
                        if (item != 0){
                          return axios.delete("/phones/contact/ajax/delete/"+item);
                        } 
                    }))
                    
                )
                .catch(
                    resp=>{
                      console.log(resp); 
                    }
                );
            },
            saveContacts(){
                var pId = this.data.person.id;
                return Promise.all(
                    this.contacts.map(function(item){
                        return item.list.map(function (itm){
                            if (itm.id === 0){
                                axios.post("/phones/contact/ajax/add/"+pId,itm)
                                    .then(resp=>{
                                        $.notify("Контакт добавлен", resp.data);
                                    });
                            }else{
                                axios.put("/phones/contact/ajax/update/"+pId,itm).then(resp=>{
                                        $.notify("Контакт обновлен", resp.data);
                                    });  
                            }
                        })
                    })
                )
            },
            changeMainContact(e){
                var mCheck = e.target.value;
                this.mainContact = mCheck;
                console.log(mCheck);
                this.data.person.contacts.forEach(function(item, i){
                    if (item.id == mCheck) item.rank = 1;
                    else item.rank = null;
                });
                
                
            }
            
        },
        watch:{
            fired: function(){
                if (this.fired === true){
                    this.babyCare = false;
                    this.data.person.status = 2;
                }else{
                    this.fired = false;
                    this.babyCare = false;
                    this.data.person.status = null;
                }
            },
            babyCare: function(){
                if (this.babyCare === true){
                    this.fired = false;
                    this.data.person.status = 1;
                }else{
                    this.fired = false;
                    this.babyCare = false;
                    this.data.person.status = null;
                }
            },
            selectedPool: function(){
                this.freeContacts = [];
                axios.get("/phones/pool/ajax/free/"+this.selectedPool.id).then(
                       request=>{
                            if (request.data.length>0){
                                for(i=0;i<request.data.length;i++){
                                   
                                        this.freeContacts.push(request.data[i]);
                                   
                                }
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
            axios.get("ajax/get/"+this.$router.currentRoute.query.id)
                    .then(
                       request=>{
                           this.data = request.data;
                           this.rooms = _.uniqBy(request.data.person.contacts,"room");
                           return this;
                       })
                    .then(
                        request=>{
                       
                           if (request.data.person.status == 2){
                               request.fired = true;
                           }
                           if (request.data.person.status == 1){
                               request.babyCare = true;
                           }
                            
                          
                           for(i=0;i<request.rooms.length;i++){
                               var contact =[];
                               for(j=0;j<request.data.person.contacts.length;j++){
                                   if (request.rooms[i].room == request.data.person.contacts[j].room){
                                       contact.push(request.data.person.contacts[j]);
                                   }
                               }
                               if (i === 0){
                                   if (request.rooms[i].room == null){
                                        request.contacts.push({"room": "Нет_комнаты", "list":contact, "active":"active", "ref": "#Нет_комнаты", "cls": "tab-pane fade in active"});
                                   }else {
                                          request.contacts.push({"room": request.rooms[i].room, "list":contact, "active":"active", "ref": "#"+_.escapeRegExp(request.rooms[i].room), "cls": "tab-pane fade in active"});
                                   }
                                
                               }else{
                                   if (request.rooms[i].room == null){
                                       request.contacts.push({"room": "Нет_комнаты", "list":contact, "active":"", "ref": "#Нет_комнаты","cls": "tab-pane fade"});
                                   }else {
                                       request.contacts.push({"room": request.rooms[i].room, "list":contact, "active":"", "ref": "#"+_.escapeRegExp(request.rooms[i].room), "cls": "tab-pane fade"});
                                   }
                                   
                               }
                               
                           }
                       }
                    )
                    .catch(
                        err=>{
                            console.log(err);
                        }
                    );
            
                    axios.get("/phones/pool/ajax/list")
                        .then(
                            request=>{
                               this.pools = request.data;
                           }
                        )
                        .catch(
                            err=>{
                                console.log(err);
                            }
                        );
                
                axios.get("/phones/person/ajax/get/image/"+this.$router.currentRoute.query.id)
                    .then(response=>{
                        this.image = "data:image/jpeg;base64,"+response.data;
                    }
                        
                    )
                    .catch(err=>{
                        console.log(err);
                    });
            
            
        }
});
</script>