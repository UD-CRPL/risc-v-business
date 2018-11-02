package riscvbusiness

import chisel3._

class ALU extends Module {
  val io = IO(new Bundle {
    val in0 = Input(UInt(32.W))
    val in1 = Input(UInt(32.W))
    val op  = Input(UInt(4.W))
    val out = Output(UInt(32.W))
  })
  when (io.op === 0.U(4.W)) {
    io.out := io.in0 + io.in1
  } .elsewhen (io.op === 1.U) {
    io.out := io.in0 - io.in1
  } .elsewhen (io.op === 8.U) {
    io.out := io.in0 ^ io.in1
  }
}

