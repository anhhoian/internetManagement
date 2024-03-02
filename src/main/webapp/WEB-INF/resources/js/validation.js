function deleteItem (event){
	let decision = confirm("Có phải bạn muốn xóa");
	if (!decision){
		event.preventDefault();
	}
}

$(document).ready(()=> {
	$.validator.addMethod("pattern", (value, element, pattern)=> {
        return pattern.test(value);
	});
	
	$("#createCustomer").validate({
	    rules : {
			maKH : {
				required : true ,
				pattern :  /^(KH)[0-9]{3}$/
			},
	        tenKH : {
	            required : true
	        }, 
	        diaChi : {
	        	required : true
	        },
	        soDienThoai : {
	        	required : true,
	        	pattern : /^((090)|(091)|(\(84\)\+90)|(\(84\)\+91))[0-9]{7}$/
	        },
	        diaChiEmail : {
	        	required : true,
	        	pattern : /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/
	        }
	    },
	    messages : {
			maKH : {
	            required : "Mã là bắt buộc",
	            pattern : "Sai định dạng mã (KHXXX)"
	        },
	    	tenKH : {
	            required : "Tên là bắt buộc"
	        }, 
	        diaChi : {
	        	required : "Địa chỉ là bắt buộc"
	        },
	        soDienThoai : {
	        	required : "Số điện thoại là bắt buộc",
	        	pattern : "Số điện thoại không đúng định dạng"
	        },
	        diaChiEmail : {
	        	required : "Email là bắt buộc",
	        	pattern : "Email không đúng định dạng"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#createMachine").validate({
	    rules : {
	        maMay : {
	            required : true,
	            pattern :  /^(MM)[0-9]{3}$/
	        }, 
	        viTri : {
	        	required : true
	        },
	        trangThai : {
				required : true
			}
	    },
	    messages : {
	    	maMay : {
	            required : "Mã máy là bắt buộc",
	            pattern : "Sai định dạng mã (MMXXX)"
	        }, 
	        viTri : {
	        	required : "Vị trí là bắt buộc"
	        },
	        trangThai : {
				required : "Trạng thái là bắt buộc"
			}
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#createService").validate({
	    rules : {
			maDichVu : {
	            required : true,
	            pattern :  /^(DV)[0-9]{3}$/
	        }, 
	        tenDichVu : {
	            required : true
	        }, 
	        donViTinh : {
	        	required : true
	        },
	        dongia : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
			maDichVu : {
	            required : "Mã là bắt buộc",
	            pattern : "Sai định dạng mã (DVXXX)"
	        }, 
	    	tenDichVu : {
	            required : "Tên là bắt buộc"
	        }, 
	        donViTinh : {
	        	required : "Đơn vị tính là bắt buộc"
	        },
	        dongia : {
	        	required : "Đơn giá là bắt buộc",
	        	pattern : "Đơn giá phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#dkSuDungMay").validate({
	    rules : {
			maKH : {
				required : true
			},
			maMay : {
				required : true
			},
	        ngayBatDauSuDung : {
	            required : true
	        }, 
	        gioBatDauSuDung : {
	        	required : true
	        },
	        thoiGianSuDung : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
			maKH : {
				required : "Mã khách hàng là bắt buộc"
			},
			maMay : {
				required : "Mã máy là bắt buộc"
			},
	    	ngayBatDauSuDung : {
	            required : "Ngày bắt đầu sử dụng là bắt buộc"
	        }, 
	        gioBatDauSuDung : {
	        	required : "Giờ bắt đầu sử dụng là bắt buộc"
	        },
	        thoiGianSuDung : {
	        	required : "Thời gian sử dụng là bắt buộc",
	        	pattern : "Thời gian sử dụng phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
	
	$("#dkSuDungDV").validate({
	    rules : {
			maKH : {
				required : true
			},
			maDichVu : {
				required : true
			},
	        ngaySuDung : {
	            required : true
	        }, 
	        gioSuDung : {
	        	required : true
	        },
	        soLuong : {
	        	required : true,
	        	pattern : /^[1-9][0-9]*$/
	        }
	    },
	    messages : {
			maKH : {
				required : "Mã khách hàng là bắt buộc"
			},
			maDichVu : {
				required : "Mã dịch vụ là bắt buộc"
			},
	    	ngaySuDung : {
	            required : "Ngày sử dụng là bắt buộc"
	        }, 
	        gioSuDung : {
	        	required : "Giờ sử dụng là bắt buộc"
	        },
	        soLuong : {
	        	required : "Số lượng là bắt buộc",
	        	pattern : "Số lượng phải là số nguyên dương"
	        }
	    },
	    submitHandler: function(form) {
	        return true;
	    }
	});
});