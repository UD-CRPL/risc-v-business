package riscvbusiness

import chisel3.iotesters.{PeekPoseTester, Driver, ChiselFlatSpec}

class ALUTests(c: ALU) extends PeekPokeTester(c) {
  for (i <- 0 until 10) {
    val in0 = rnd.nextInt(1 << 32.W)
    val in1 = rnd.nextInt(1 << 32.W)
    poke(c.io.in0, in0)
    poke(c.io.in1, in1)
    poke(c.io.op, 8.U(4.W))
    step(1)
    expect(c.io.out, (in0 ^ in1))
  }
}
