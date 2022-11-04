INSERT INTO public.produto(descricao, descricao_reduzida, preco_compra, preco_venda) VALUES ('Arroz Integral Uniao', 'Arroz Integral', '10.50', '16.70');
INSERT INTO public.produto(descricao, descricao_reduzida, preco_compra, preco_venda) VALUES ('Farinha de Trigo 00 Dona Benta', 'Farinha de Trigo', '17.00', '25.70');

INSERT INTO public.cliente(cpf, nome, rg) VALUES ('96259414013', 'Joao da Silva', '266971635');
INSERT INTO public.cliente(cpf, nome, rg) VALUES ('80968125050', 'Renato Santana', '106054995');

INSERT INTO public.forma_pagamento(descricao) VALUES ('Cartao');
INSERT INTO public.forma_pagamento(descricao) VALUES ('Dinheiro');

INSERT INTO public.pedido(id_cliente, id_forma_pagamento) VALUES (1, 1);
INSERT INTO public.item_pedidos(quantidade, valor_item, id_pedido, id_produto) VALUES ('10', '16.70', 1, 1);
INSERT INTO public.item_pedidos(quantidade, valor_item, id_pedido, id_produto) VALUES ('5', '25.70', 1, 2);

INSERT INTO public.pedido(id_cliente, id_forma_pagamento) VALUES (2, 2);
INSERT INTO public.item_pedidos(quantidade, valor_item, id_pedido, id_produto) VALUES ('3', '16.70', 2, 1);
INSERT INTO public.item_pedidos(quantidade, valor_item, id_pedido, id_produto) VALUES ('1', '25.70', 2, 2);