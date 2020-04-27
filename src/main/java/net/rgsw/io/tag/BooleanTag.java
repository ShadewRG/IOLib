/*
 * Copyright (c) 2020 RedGalaxy & contributors
 * All rights reserved. Do not distribute.
 *
 * For a full license, see LICENSE.txt
 */

package net.rgsw.io.tag;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class BooleanTag implements Tag {
    private boolean value;

    public BooleanTag( boolean value ) {
        this.value = value;
    }

    public BooleanTag() {
    }

    public boolean getValue() {
        return value;
    }

    public void setValue( boolean value ) {
        this.value = value;
    }

    @Override
    public void read( DataInput in, TagFormat format ) throws IOException {
        value = in.readBoolean();
    }

    @Override
    public void write( DataOutput out, TagFormat format ) throws IOException {
        out.writeBoolean( value );
    }
}
