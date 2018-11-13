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

/* Formatting function for row details - modify as you need */
function format ( d ) {
    // `d` is the original data object for the row
    console.log(d);
      var d_org = "";
        var d_job = "";
        var d_image = "resources/images/no_photo.jpg";
        var d_room = "";
        if(d.organization !== null) d_org = d.organization.name;
        if(d.contacts !== null) {
            d_room = _.uniqBy(d.contacts, 'room');
            d_room = d_room.map(function (item){
                if (item.room != null) return item.room;
            });
            
            d_room = _.join(d_room, ' ');
        }
        if(d.job !== null) d_job = d.job.name;
        if(d.personImageses.length > 0) d_image = "data:image/jpeg;base64,"+d.personImageses[0].image;
        
        console.log(d_room);
    /*  return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td><strong>Подразделение:</strong></td>'+
            '<td>'+ d_org+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td><strong>Должность:</strong></td>'+
            '<td>'+d_job+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td></td>'+
            '<td><img style="width:200px" src="'+d_image+'" /></td>'+
        '</tr>'+
    '</table>'; */
    return '<div class="container">'+
	'<div class="row">'+
		'<div class="col-md-8 col-lg-6">'+
    	' <div>'+
           ' <div class="col-sm-12">'+
           ' <div class="col-xs-12 col-sm-4 text-center">'+
                   ' <figure>'+
                      '  <img src="'+d_image+'" alt="" class="img-rounded img-responsive">'+
                        
                  '  </figure>'+
               ' </div>'+
              '  <div class="col-xs-12 col-sm-8">'+
                   ' <h2>'+d.surname+ ' '+d.name+' '+d.middlename+'</h2>'+
                   ' <p><strong>Должность: </strong> '+d_job+' </p>'+
                   ' <p><strong>Подразделение: </strong> '+d_org+' </p>'+
                   ' <p><strong>Комнаты: </strong>'+
                     '   <span class="tags">'+d_room+'</span> '+
                  '  </p>'+
              '  </div>         '+    
               
           ' </div>    '+        
            
    	' </div>   '+              
		'</div>'+
	'</div>'+
'</div>'
}
    
var table = $('#contact-table').DataTable({
        "processing": true,
        "serverSide": true,
        
       
        "ajax":{
            "url":  "person/ajax/get",
            "dataType": "JSON",
            "dataSrc": "data",
        },
        "createdRow": function( row, data, dataIndex ) {
           
            row.children[0].innerHTML = "<span class='glyphicon glyphicon-plus'></span>";
        },
        
        
        "columns": [
            {
                "className":      'details-control',
                "orderable":      false,
                "data":           null,
                "defaultContent": ''
            },
            { 
                "data": null,
                "render": function ( data, type, row, meta ) {
                    
                    return data.surname+' '+data.name+' '+data.middlename;
                }
            },
            { 
                "data": "null",
                "render":function(data, type, row, meta){
                    var result = "";
                    row.contacts.forEach(function(item){
                        if (item.rank == 1) {
                            result = "<strong>"+item.type.name+":</strong> "+item.contact+"<br />";
                        }
                        if (item.type.id == 1){
                            result += "<strong>"+item.type.name+":</strong> "+item.contact+"<br />";
                        }
                    });
                    if (result == null){
                        result = "";
                    }
                    return result;
                }
            },
            
            
        ],
        
        "language": lang
    });
    
    $('#contact-table tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            // Open this row
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
    

  
  
