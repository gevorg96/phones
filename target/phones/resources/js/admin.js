$(document).ready(function (){
    $('.main-contact').click(function (){
       $('.main-contact').prop('checked',false);
        $(this).prop('checked',true);
    });
    
    /* DataTables */
    
    var lang = {
        "processing": "Подождите...",
            "search": "Поиск:",
            "lengthMenu": "Показать _MENU_ записей",
            "info": "Записи с _START_ до _END_ из _TOTAL_ записей",
            "infoEmpty": "Записи с 0 до 0 из 0 записей",
            "infoFiltered": "(отфильтровано из _MAX_ записей)",
            "infoPostFix": "",
            "loadingRecords": "Загрузка записей...",
            "zeroRecords": "Записи отсутствуют.",
            "emptyTable": "В таблице отсутствуют данные",
            "paginate": {
              "first": "Первая",
              "previous": "Предыдущая",
              "next": "Следующая",
              "last": "Последняя"
            },
            "aria": {
              "sortAscending": ": активировать для сортировки столбца по возрастанию",
              "sortDescending": ": активировать для сортировки столбца по убыванию"
            }
    }
    
    $('#ldapTable').DataTable({
        "pageLength": 20,
        "language": lang,
    });
    
    $('#adminLdapTable').DataTable({
        
        "pageLength": 20,
        "language": lang,
    });
    
    $('#adminContactTable').DataTable({
        "processing": true,
        "serverSide": true,
        
       
        "ajax":{
            "url":  "person/ajax/get",
            "dataType": "JSON",
            "dataSrc": "data",
        },
        "createdRow": function( row, data, dataIndex ) {
            row.children[1].innerHTML = row.children[1].innerHTML.replace(new RegExp(',', 'g'),"");
            if(data.status == 1 || data.status == 2){
                $(row).addClass( 'bg-danger' );
            }
        },
        
        "columns": [
            { 
                "data": null,
                "render": function ( data, type, row, meta ) {
                    
                    return data.surname+' '+data.name+' '+data.middlename;
                }
            },
            { 
                "data": "null",
                "render":function(data, type, row, meta){
                    return row.contacts.map(function(item){
                        return "<strong>"+item.type.name+":</strong> "+item.contact+"<br />";
                    });
                }
            },
            { 
                "data": "note",
                "defaultContent": " "
            },
            { 
                "data": "contactGroup",
                "defaultContent": " "
            },
            {
                "data": null,
                "render": function ( data, type, row, meta ) {
                    return '<a href="/phones/person/update?id='+data.id+'">Редактировать</a>';
                }
            }
        ],
        
        "language": lang
    });

   
    
    $('#organizationsTable').DataTable({
        "processing": true,
        "serverSide": true,
        
       
        "ajax":{
            "url":  "organization/ajax/get",
            "dataType": "JSON",
            "dataSrc": "data",
        },
        
        "columns": [
            { 
                "data": "name",
            },
            { 
                "data": "parentId",
            },
            { 
                "data": "null",
                "render": function(data, type, row, meta){
                    if (row.region != null){
                       return row.region.name
                    }else{
                        return "";
                    }
                }
                
            },
            { 
                "data": "null",
                "render": function(data, type, row, meta){
                    if (row.type != null){
                       return row.type.name
                    }else{
                        return "";
                    }
                }
            },
            {
                "data": null,
                "render": function ( data, type, row, meta ) {
                    return '<a href="/phones/organization/update?id='+data.id+'">Редактировать</a>';
                }
            },
            {
                "data": null,
                "render": function ( data, type, row, meta ) {
                    return '<a href="/phones/organization/delete?id='+data.id+'">Удалить</a>';
                }
            }
        ],
        
        "language": lang
    });
    
    $('#regionsTable').DataTable({
        "processing": true,
        "serverSide": true,
        
       
        "ajax":{
            "url":  "regions/ajax/get",
            "dataType": "JSON",
            "dataSrc": "data",
        },
        
        "columns": [
            { 
                "data": "name",
            },
            {
                "data": null,
                "render": function ( data, type, row, meta ) {
                    return '<a href="/phones/regions/update?id='+data.id+'">Редактировать</a>';
                }
            },
            {
                "data": null,
                "render": function ( data, type, row, meta ) {
                    return '<a href="/phones/regions/delete?id='+data.id+'">Удалить</a>';
                }
            }
        ],
        
        "language": lang
    });
    
     /* End DataTables */
    
});