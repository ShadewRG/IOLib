/*
 * Copyright (c) 2020 RGSW
 * Licensed under the Apache 2.0 license
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ByteArrayTag implements Tag {
    private byte[] value;

    public ByteArrayTag( byte... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    public ByteArrayTag() {
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue( byte... value ) {
        if( value == null ) throw new NullPointerException( "Value must not be null" );
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        int len = in.readInt();
        byte[] array = new byte[ len ];
        for( int i = 0; i < len; i++ ) {
            array[ i ] = in.readByte();
        }
        value = array;
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeInt( value.length );
        for( byte b : value ) {
            out.writeByte( b );
        }
    }
}
