$(document).ready(function() {
    $('#booksTable').on('load',function(){
      $('#booksTable').DataTable();
    });
    $('#availabilityTable').on('load',function(){
      $('#availabilityTable').DataTable();
    });

} );
$('#addButton').click(function(){
  swal("Book Title", "has been added to the catalog.", "success")
})

$('#deleteBook').click(function(){
  swal({
  title: "Are you sure?",
  text: "You will not be able to recover this book.",
  type: "warning",
  showCancelButton: true,
  confirmButtonColor: "#DD6B55",
  confirmButtonText: "Delete",
  closeOnConfirm: false
},
function(){
  swal("Deleted", "Magic 101 has been deleted.", "success");
});
})
