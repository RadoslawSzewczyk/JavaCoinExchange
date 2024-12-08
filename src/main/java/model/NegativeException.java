package model;

import lombok.NoArgsConstructor;

/**
 *
 * @author radek
 */
@NoArgsConstructor
public class NegativeException extends RuntimeException
{
    public NegativeException(String msg)
    {
        super(msg);
    }
}
