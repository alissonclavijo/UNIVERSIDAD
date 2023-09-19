import { Module } from '@nestjs/common';
import { UserService } from './services/user.service';
import { UserController } from './controllers/user.controller';
import { TypeOrmModule } from '@nestjs/typeorm';
import { Actividad } from 'src/entities/activity.entity';
import { Administrador } from 'src/entities/administrator.entity';
import { Empresa } from 'src/entities/enterprise.entity';
import { Registro } from 'src/entities/register.entity';
import { Premio } from 'src/entities/reward.entity';
import { Usuario } from 'src/entities/user.entity';

@Module({
  imports: [
    TypeOrmModule.forFeature([Actividad, Administrador, Empresa, Registro, Premio, Usuario])
  ],
  providers: [UserService],
  controllers: [UserController]
})
export class UserModule {}
