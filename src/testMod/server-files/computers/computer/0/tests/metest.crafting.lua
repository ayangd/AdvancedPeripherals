local pretty = require("cc.pretty")

local p = peripheral.find("meBridge")
test.assert(p)
local items = pretty.pretty(p.listItems())
test.assert(items, "Items sloudn't be nil")
test.log(pretty.render(items))
local stone, stoneErr = p.getItem({name = "minecraft:stone"})
test.eq(nil, stoneErr, "Stone err should be nil")
test.neq(nil, stone, "Stone should not be nil")
test.eq(64, stone.count, "should be 64 stone")
local stoneBricks = p.getItem({name = "minecraft:stone_bricks"})
test.eq(0, stoneBricks.count, "should be 0 stone bricks")
test.eq(false, p.isItemCrafting({name = "minecraft:stone_bricks"}), "Item is crafting?...")
local craft, craftErr = p.craftItem({name = "minecraft:stone_bricks", count = 1})
test.eq(nil, craftErr, "Craft err should be nul");
test.neq(nil, craft, "Craft result shouldn't be nil")
test.eq(1, craft.stack.item.count, "Count should be correct")
test.eq("[Stone Bricks]", craft.stack.item.displayName, "Name should be correct")
test.eq(true, p.isItemCrafting({name = "minecraft:stone_bricks"}), "Item is not crafting?...")
sleep(1)
stoneBricks = p.getItem({name = "minecraft:stone_bricks"})
test.eq(4, stoneBricks.count, "should be 4 stone bricks")