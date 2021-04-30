$(document).ready(function() {
	
	//load trang 
	$(window).on('load', function(event) {
	$('body').removeClass('preloading');
	 $('.load').delay(1000).fadeOut('fast');
	//$('.loader').delay(1000).fadeOut('fast');
});
	
	
	
	var dichvuCu = getListDvCt();
	
	function getmaDVCTY(ArrDv){
		
			
			$('input#check_2').each(function(index, el) {
				if($(this).val() == ArrDv){
					return $(this).next().text();
				}
				
			})
		
	}
	
	
		$('.itemBase input').blur(function() {

		if (!$(this).val()) {

			alert("Không được bỏ trống dữ liệu!!");

		}
	});
		function checkEmpty(checkEmptyValue) {



		$('.itemBase input').each(function(index, el) {
			if (!$(this).val()) {

				checkEmptyValue = true;
			}
		});  // check dich vu cong ty update
		return checkEmptyValue;

	}  // end function
	function getListDvCt() {
		arrDv = [];
		$('input#check_1').each(function(index, el) {
			if (this.checked) {
				arrDv.push($(this).val());
			}
		});
		return arrDv;
	}
	function checkExist(madv , Arrdv){
		for (var i = 0; i < Arrdv.length; i++) {

		if(madv == Arrdv[i]) return true;
	}
	return false;
		
	}
	function getDvNew(listMadv,dichvuCu){
			var	ListdvAdd = [];
		for (var i = 0; i < listMadv.length; i++) {	
			flag1 = false;
		for (var j = 0; j < dichvuCu.length; j++) {
			
				if(listMadv[i]== dichvuCu[j]){
					flag1 = true;
				} 
							

		}
		if(flag1 == false){
			ListdvAdd.push(listMadv[i]);
		}
	}
		return ListdvAdd;
	}
	function getDvRemove(listMadv,dichvuCu){
		var	ListdvDelete = [];
		for (var i = 0; i < dichvuCu.length; i++) {
				flag2 = false;
		for (var j = 0; j < listMadv.length; j++) {
			
			if(dichvuCu[i]== listMadv[j] ){
					flag2 = true;
			}
			
		}
			if(flag2 == false){
				ListdvDelete.push(dichvuCu[i]);
			}	
		}
		return ListdvDelete;
	}
	
	
	
	
	
	
		$("#datatable").on("click", ".xoacongty", function() {
		event.preventDefault();


		var id_congty = $(this).val();
		var removeThis = $(this).closest('tr');
		console.log(id_congty);


		$.ajax({
			url: 'http://localhost:8080/api/congtys/' + id_congty,
			type: 'DELETE',
			contentType: "application/json",
			dataType: 'json',
			data: {


			},
		})
		//	removeThis.empty();
		alert("xoa cong ty thanh cong");
		removeThis.remove();



	});
	$('.removeCongtys').click(function(event) {
		var checkflag = false;
		$('input.flat').each(function(index, el) {
			if (this.checked) {
				checkflag = true;
				var spxoa = $(this).val();
				var This = $(this);
				This.closest("tr").remove();

				$.ajax({
					url: "http://localhost:8080/api/congtys/" + spxoa,
					type: "DELETE",
					data: {


					},
					success: function(value) {
						This.closest('tr').remove();
					}
				})  // het ajax

			}

		});
		if (checkflag == false) {

			alert("tich de xoa");
		}

	});
	
	
	// update dv
	$('button.updatecongty').click(function(event) {
		event.preventDefault();
		checkEmptyValue = false;
		checkEmptyValue = checkEmpty(checkEmptyValue);
		//	$('input#soDienThoai').val();
		$.isNumeric($('input#soDienThoai').val());

		if ($.isNumeric($('input#soDienThoai').val()) == false) {
			alert("Nhập lại số điện thoại");
		}
		else if ($.isNumeric($('input#vonDieuLe').val()) == false) {
			alert("Nhập lại vốn điều lệ");
		}
		else if (checkEmptyValue == false) {

			var id_congty = $(this).val();
				// check select dich vu	
			var listMadv = [];   // list dich vu update
			$('input#check_1').each(function(index, el) {
				if (this.checked) {
					listMadv.push($(this).val());
				}
			});  // check dich vu cong ty update
			if( checkExist(1,listMadv)==false) {listMadv.push(1)}
		if( checkExist(2,listMadv)==false) {listMadv.push(2)}
		console.log("dich vu cu " + dichvuCu);
	console.log("them cac dv "+getDvNew(listMadv,dichvuCu))
	console.log("xoa cac dv "+getDvRemove(listMadv,dichvuCu))
		listdvAdd = getDvNew(listMadv,dichvuCu);
	listDvRemove = getDvRemove(listMadv,dichvuCu);	
		var formData = {
				id: id_congty,
				tencongty: $('#tencongty').val(),
				soNhanVien: $('#quantity').val(),
				maSoThue: $('#maSoThue').val(),
				diaChi: $('#diaChi').val(),
				linhVucHoatDong: $('#linhVucHoatDong').val(),
				soDienThoai: $('#soDienThoai').val(),
				vonDieuLe: $('#vonDieuLe').val(),
				dtMatbang: $('#DtMatbang').val(),
				//spxoa :	$(this).val(),
				listMadv: listdvAdd,

			}
				$.ajax({
				url: 'http://localhost:8080/api/congtys/' + id_congty,
				type: 'PUT',
				contentType: "application/json",
				dataType: 'json',
				data: JSON.stringify(formData),
			})
			console.log(JSON.stringify(formData))
			alert("update thanh cong");
			window.location.reload("http://localhost:8081/"+id_congty );
		if(listDvRemove.length !=0){
			for (var i = 0; i < listDvRemove.length; i++) {
				
				$('input#check_2').each(function(index, el) {
				if($(this).val() == listDvRemove[i]){
					var txt = $(this).next().text();
			//	console.log(txt);
			// sd ajax call api
			$.ajax({
					url: "http://localhost:8080/api/dichvucongtys/" + txt,
					type: "DELETE",
					data: {


					},
					success: function(value) {
						
					}
				})  // het ajax
			
				}
				
			})
			
			}
			
		} // xu ly xoa dv cu
	//getmaDVCTY
	
		}
	else {
			alert("Không được bỏ trống dữ liệu")
		}
	
	
	
		});
	
	
	
	
}); //end ready