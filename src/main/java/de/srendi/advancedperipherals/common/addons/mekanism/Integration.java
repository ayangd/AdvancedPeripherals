package de.srendi.advancedperipherals.common.addons.mekanism;

import de.srendi.advancedperipherals.common.addons.computercraft.integrations.IntegrationPeripheralProvider;
import de.srendi.advancedperipherals.common.addons.computercraft.peripheral.EnvironmentDetectorPeripheral;
import mekanism.common.tile.TileEntityChemicalTank;
import mekanism.common.tile.TileEntityRadioactiveWasteBarrel;
import mekanism.common.tile.base.TileEntityMekanism;
import mekanism.common.tile.machine.TileEntityDigitalMiner;
import mekanism.common.tile.multiblock.TileEntityBoilerValve;
import mekanism.common.tile.multiblock.TileEntityInductionPort;

public class Integration implements Runnable {
    @Override
    public void run() {
        IntegrationPeripheralProvider.registerTileEntityIntegration(BoilerIntegration::new, TileEntityBoilerValve.class);
        IntegrationPeripheralProvider.registerTileEntityIntegration(ChemicalTankIntegration::new, TileEntityChemicalTank.class);
        IntegrationPeripheralProvider.registerTileEntityIntegration(DigitalMinerIntegration::new, TileEntityDigitalMiner.class);
        IntegrationPeripheralProvider.registerTileEntityIntegration(InductionPortIntegration::new, TileEntityInductionPort.class);
        IntegrationPeripheralProvider.registerTileEntityIntegration(WasteBarrelIntegration::new, TileEntityRadioactiveWasteBarrel.class);
        IntegrationPeripheralProvider.registerTileEntityIntegration(GenericMekanismIntegration::new, TileEntityMekanism.class, 100);

        EnvironmentDetectorPeripheral.addIntegrationPlugin(EnvironmentDetectorPlugin::new);
    }
}
