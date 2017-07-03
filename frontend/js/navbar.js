var searchbarclicked = false;
var searchbar = $('#search-navbar');
$('#search-navbar').hide();

$(document).ready(function(){
  $("#enable-search").on('click', function() {
    toggleSearchBar();
  });
});

function toggleSearchBar() {
  if(searchbarclicked == true) {
    searchbar.hide(500);
    searchbarclicked = false;
  } else if(searchbarclicked == false) {
    searchbar.show(500);
    searchbarclicked = true;
  }
};
