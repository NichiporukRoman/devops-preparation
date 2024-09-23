import pytest

def test_calculate():
    assert eval("2 + 2") == 4
    assert eval("3 * 4 - 2") == 10
    assert eval("10 / 2") == 5

def test_invalid_expression():
    assert eval("10 / 0") == "Ошибка: division by zero"
    assert eval("invalid expression") == "Ошибка: invalid syntax"