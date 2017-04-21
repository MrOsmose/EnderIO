package crazypants.enderio.conduit.item.filter;

import java.util.List;

import com.enderio.core.client.gui.widget.GhostSlot;

import crazypants.enderio.conduit.gui.GuiExternalConnection;
import crazypants.enderio.conduit.gui.item.IItemFilterGui;
import crazypants.enderio.conduit.item.IItemConduit;
import crazypants.enderio.conduit.item.NetworkedInventory;
import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IItemFilter {

  @SideOnly(Side.CLIENT)
  IItemFilterGui getGui(GuiExternalConnection gui, IItemConduit itemConduit, boolean isInput);

  void readFromNBT(NBTTagCompound nbtRoot);

  void writeToNBT(NBTTagCompound nbtRoot);

  void writeToByteBuf(ByteBuf buf);

  void readFromByteBuf(ByteBuf buf);

  /**
   * Checks if the given item passes the filter or not.
   * @param inv the attached inventory - or null when used without an inventory (eg for a GUI)
   * @param item the item to check
   * @return true if the item is allowed to pass
   */
  boolean doesItemPassFilter(NetworkedInventory inv, ItemStack item);

  /**
   * Unused?
   */
  @Deprecated
  boolean doesFilterCaptureStack(NetworkedInventory inv, ItemStack item);

  boolean isValid();

  boolean isSticky();

  void createGhostSlots(List<GhostSlot> slots, int xOffset, int yOffset, Runnable cb);

  int getSlotCount();

}
