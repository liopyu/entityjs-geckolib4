package net.liopyu.liolib;

import net.minecraft.resources.ResourceLocation;

import java.io.Serial;

/**
 * Generic {@link Exception} wrapper for LioLib.<br>
 * Mostly just serves as a marker for internal error handling.
 */
public class LioLibException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	public LioLibException(ResourceLocation fileLocation, String message) {
		super(fileLocation + ": " + message);
	}

	public LioLibException(ResourceLocation fileLocation, String message, Throwable cause) {
		super(fileLocation + ": " + message, cause);
	}
}
