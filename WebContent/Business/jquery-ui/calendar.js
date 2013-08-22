$(function() {
	var dates = $("#sdate").datepicker({
		defaultDate: "-1w",//前一个月份开始
		numberOfMonths: 2,//显示日历的个数
		onSelect: function(selectedDate) {
			var option = (this.id == "sdate") ? "minDate" : "maxDate",
			date = $.datepicker.parseDate($.datepicker._defaults.dateFormat, selectedDate);
			dates.not(this).datepicker("option", option, date);
		}
	});
});
