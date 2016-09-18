/**
 * @Title: common.js
 * @Package src/main/webapp/WEB-INF/static/js
 * @Description: 公共js
 * @author LiuTao
 * @date 2016年9月7日
 * @version V1.0
 */

/**
 * 表单数据转json 格式{"param":{"userName":"liuTao"}}
 */
$.fn.serializeJson = function() {
	var o = {};
	var p = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	p.param = o;
	return JSON.stringify(p);
}