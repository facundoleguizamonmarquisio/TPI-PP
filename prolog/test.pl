padre(mauro,juan).
padre(mauro,ana).
padre(juan,luis).
padre(juan,maria).
abuelo(X,Y):-padre(X,Z),padre(Z,Y).
hermano(X,Y):-padre(Z,X),padre(Z,Y),X\=Y.
tio(X,Y):-padre(Z,Y),hermano(X,Z).