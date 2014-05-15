/**
 *
 */
$(document).ready(function() {

	$('.money').mask('000.000.000.000.000,00', {reverse: true});

	$('#valorAtual').on('keypress', function(e) {
		var code = e.keyCode || e.which;
		if (code == 43) {
			e.preventDefault();
			var valor = 0.0;
			valor = parseFloat($('#valorAtual').val().replace(',','.'));
			valor = valor + 0.01;
			$('#valorAtual').val(valor.toFixed(2));
		}
	});
});