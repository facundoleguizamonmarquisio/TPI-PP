% Archivo de prueba para verificar integración con Java + JPL
% Ubicación esperada: src/prolog/test_base.pl

% Hechos simples
numero(1).
numero(2).
numero(3).

% Regla
mayor(X, Y) :- X > Y.

% Predicado para probar éxito simple
saludo('Hola desde Prolog').

% Lista de prueba
lista([a, b, c]).
