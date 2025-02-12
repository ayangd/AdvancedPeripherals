local p = peripheral.find("variableStore")
test.assert(p, "store not found")
test.assert(p.list(), "nothing to read")
test.eq({ dynamic = false, id = 0, type = "string", value = "test1" }, p.read(1), "first variable error")
test.eq({ dynamic = false, id = 1, type = "string", value = "test2" }, p.read(2), "second variable error")
test.eq({ dynamic = true, id = 2, type = "string", value = "test1test2" }, p.read(3), "product variable error")
