package openwolves.asm;

import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.minecraft.launchwrapper.IClassTransformer;

public class OWClassTransformerOverride implements IClassTransformer
{
	@Override
	public byte[] transform(String arg0, String arg1, byte[] arg2) 
	{
		//if (arg0.equals("te") || arg0.equals("net.minecraft.entity.monster.EntityCreeper")) 
		//{
			//System.out.println("********* INSIDE CREEPER TRANSFORMER ABOUT TO PATCH: " + arg0);
			//arg2 = patchClassInJar(arg0, arg2, arg0, BTDFMLLoadingPlugin.location);
		//}
		
		//return arg2;
		return null;
	}

	public byte[] patchClassInJar(String name, byte[] bytes, String ObfName, File location) 
	{
		try 
		{
			ZipFile zip = new ZipFile(location);
			ZipEntry entry = zip.getEntry(name.replace('.', '/') + ".class");

			if (entry == null) 
			{
				System.out.println(name + " not found in " + location.getName());
			} 
			else 
			{

				InputStream zin = zip.getInputStream(entry);
				bytes = new byte[(int) entry.getSize()];
				zin.read(bytes);
				zin.close();
				System.out.println("[OpenWolves] " + "Class " + name + " patched!");
			}
			zip.close();
		} 
		catch (Exception e) 
		{
			throw new RuntimeException("Error overriding " + name + " from " + location.getName(), e);
		}

		return bytes;
	}
}
